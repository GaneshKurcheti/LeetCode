import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Nodes {
  String word;
  int count;

  public Nodes(String word, int count) {
    this.word = word;
    this.count = count;
  }
}

public class TopKFrequentPractice {

  public static List<String> getWords(String[] words, int count) {
    HashMap<String, Nodes> map = new HashMap<>();
    PriorityQueue<Nodes> maxHeap = new PriorityQueue<>(1, new Comparator<Nodes>() {
      public int compare(Nodes n1, Nodes n2) {
        if (n1.count > n2.count) {
          return -1;
        }
        if (n2.count > n1.count) {
          return 1;
        }
        if (n2.count == n1.count) {
          if (n2.word.compareTo(n1.word) > 0) {
            return -1;
          } else if (n2.word.compareTo(n1.word) < 0) {
            return 1;
          }
        }
        return 0;
      }
    });
    for (int i = 0; i < words.length; i++) {
      if (map.containsKey(words[i])) {
        map.get(words[i]).count += 1;
        maxHeap.add(maxHeap.remove());
      } else {
        Nodes n = new Nodes(words[i], 1);
        map.put(words[i], n);
        maxHeap.add(n);
      }
    }
    List<String> res = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      res.add(maxHeap.poll().word);
    }
    return res;
  }

  public static void main(String[] args) {
    String[] words = { "I", "love", "leetcode", "leetcode", "leetcode", "I", "I", "test", "test" };
    List<String> res = new ArrayList<>();
    res = getWords(words, 2);
    for (var r : res) {
      System.out.println(r);
    }
  }
}
