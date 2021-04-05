import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class NodeK {
  public int value;
  public int count;

  public NodeK(int value) {
    this.value = value;
    count = 1;
  }
}

public class TopKFrequentElements {

  public static int[] getFrequentEles(int[] arr, int k) {
    int[] res = new int[k];
    // PriorityQueue<NodeK> maxHeap = new PriorityQueue<>((x, y) -> y.count -
    // x.count);
    HashMap<Integer, NodeK> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.get(arr[i]).count += 1;
      } else {
        NodeK n = new NodeK(arr[i]);
        // maxHeap.add(n);
        map.put(arr[i], n);
      }
    }
    NodeK[] arr1 = map.values().toArray(new NodeK[map.values().size()]);
    Arrays.sort(arr1, (x, y) -> y.count - x.count);
    for (int i = 0; i < res.length; i++) {
      res[i] = arr1[i].value;
    }
    return res;
  }

  public static void main(String[] args) {
    int k = 4;
    int[] arr = { 2, 5, 8, 2, 5, 5, 5, 3, 7, 1, 6, 2, 9, 4, 90, 4, 2, 5, 3 };
    System.out.println(Arrays.toString(getFrequentEles(arr, k)));
  }
}
