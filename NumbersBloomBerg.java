import java.util.HashMap;
import java.util.List;

/**
 * NumbersBloomBerg
 */
public class NumbersBloomBerg {
  public static int getCount() {
    HashMap<Integer, Integer> firstThree = new HashMap<>();
    HashMap<Integer, Integer> lastThree = new HashMap<>();
    for (int i = 100; i <= 999; i++) {
      String t = i + "";
      int value = (Character.getNumericValue(t.charAt(0)) + Character.getNumericValue(t.charAt(1))
          + Character.getNumericValue(t.charAt(2)));
      if (firstThree.containsKey(value)) {
        firstThree.put(value, firstThree.get(value) + 1);
        lastThree.put(value, lastThree.get(value) + 1);
      } else {
        firstThree.put(value, 1);
        lastThree.put(value, 1);
      }
    }
    for (int i = 1; i < 100; i++) {
      if (i < 10) {
        lastThree.put(i, lastThree.get(i) + 1);
      } else {
        String t = i + "";
        int value = (Character.getNumericValue(t.charAt(0)) + Character.getNumericValue(t.charAt(1)));
        lastThree.put(value, lastThree.get(value) + 1);
      }
    }
    int result = 0;
    for (var each : firstThree.entrySet()) {
      result = result + (each.getValue() * lastThree.get(each.getKey()));
    }
    return result;
  }

  public static void main(String[] args) {
    int count = 0;
    for (int i = 100000; i <= 999999; i++) {
      String t = i + "";
      if ((Character.getNumericValue(t.charAt(0)) + Character.getNumericValue(t.charAt(1))
          + Character.getNumericValue(t.charAt(2))) == (Character.getNumericValue(t.charAt(3))
              + Character.getNumericValue(t.charAt(4)) + Character.getNumericValue(t.charAt(5)))) {
        count++;
      }
    }
    System.out.println(count);
    System.out.println(getCount());
  }
}