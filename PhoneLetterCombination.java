import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombination {
  public static List<String> result = new ArrayList<>();
  public static HashMap<Integer, char[]> map = new HashMap<>();

  public static void getALLPossibilities(String num, int index, String currString) {
    if (index == num.length()) {
      result.add(currString);
      return;
    }
    int number = Character.getNumericValue(num.charAt(index));
    for (int i = 0; i < map.get(number).length; i++) {
      String temp = currString + map.get(number)[i];
      getALLPossibilities(num, index + 1, temp);
    }
  }

  public static void main(String[] args) {
    String test = "345";

    map.put(2, "abc".toCharArray());
    map.put(3, "def".toCharArray());
    map.put(4, "ghi".toCharArray());
    map.put(5, "jkl".toCharArray());
    map.put(6, "mno".toCharArray());
    map.put(7, "pqrs".toCharArray());
    map.put(8, "tuv".toCharArray());
    map.put(9, "wxyz".toCharArray());
    getALLPossibilities(test, 0, "");
    System.out.println(Arrays.toString(result.toArray()));
  }

}
