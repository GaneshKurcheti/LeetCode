import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BracesCombination {
  static List<String> vals;

  public static void getAllPossible(String current, int opens, int closes) {
    if (opens == 0 && closes == 0) {
      vals.add(current);
      return;
    }
    if (opens == 0 && closes != 0) {
      getAllPossible(current + ")", opens, closes - 1);
    } else if (opens == closes) {
      getAllPossible(current + "(", opens - 1, closes);
    } else {
      getAllPossible(current + "(", opens - 1, closes);
      getAllPossible(current + ")", opens, closes - 1);
    }
  }

  public static void getAllPossibleCaller(int n) {
    vals = new ArrayList<>();
    getAllPossible("", n, n);
  }

  public static void main(String[] args) {
    int n = 3;
    getAllPossibleCaller(n);
    System.out.println(Arrays.toString(vals.toArray()));
  }
}
