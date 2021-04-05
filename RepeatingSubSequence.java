import java.util.Arrays;

public class RepeatingSubSequence {
  public static String getLargest(String s1, String s2) {
    String result = "";
    int[][] arr = new int[s1.length() + 1][s2.length() + 1];
    for (var each : arr) {
      Arrays.fill(each, 0);
    }
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && i - 1 != j - 1) {
          arr[i][j] = arr[i - 1][j - 1] + 1;
        } else {
          arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
        }
      }
    }
    for (var each : arr) {
      System.out.println(Arrays.toString(each));
    }
    return result;
  }

  public static void main(String[] args) {
    String s1 = "helloooo";
    System.out.println(getLargest(s1, s1));
  }

}
