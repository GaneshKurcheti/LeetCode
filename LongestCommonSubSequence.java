import java.util.*;

public class LongestCommonSubSequence {
  public static String getLargest(String s1, String s2) {
    int[][] arr = new int[s1.length() + 1][s2.length() + 1];
    for (var each : arr) {
      Arrays.fill(each, 0);
    }
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          arr[i][j] = 1 + arr[i - 1][j - 1];
        } else {
          arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
        }
      }
    }
    for (var t : arr) {
      System.out.println(Arrays.toString(t));
    }
    String result = "";
    int i = s1.length();
    int j = s2.length();
    while (i != 0 && j != 0 && arr[i][j] != 0) {
      if (arr[i - 1][j] == arr[i][j]) {
        i = i - 1;
        continue;
      }
      if (arr[i][j - 1] == arr[i][j]) {
        j = j - 1;
        continue;
      }
      if (arr[i - 1][j - 1] + 1 == arr[i][j]) {
        result = s2.charAt(j - 1) + result;
        i = i - 1;
        j = j - 1;
        continue;
      }
      break;
    }
    return result;
  }

  public static void main(String[] args) {
    String s1 = "keillertestingt";
    String s2 = "illeastit";
    System.out.println(getLargest(s1, s2));
  }

}
