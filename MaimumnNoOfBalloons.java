import java.util.HashMap;

public class MaimumnNoOfBalloons {
  public static int getBallonsCount(String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      } else {
        map.put(str.charAt(i), 1);
      }
    }
    int[] arr = { map.getOrDefault('b', 0), map.getOrDefault('a', 0), map.getOrDefault('l', 0) / 2,
        map.getOrDefault('o', 0) / 2, map.getOrDefault('n', 0) };
    int min = arr[0];
    for (int i : arr) {
      min = Math.min(i, min);
    }
    return min;

  }

  public static void main(String[] args) {
    String test = "balllllllllllloooooonnnnbbbaaa";
    System.out.println(getBallonsCount(test));
  }
}
