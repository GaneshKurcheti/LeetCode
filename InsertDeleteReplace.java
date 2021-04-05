import java.util.Arrays;

public class InsertDeleteReplace {
  public static int getCount(String s1, String s2) {
    int[][] arr = new int[s1.length() + 1][s2.length() + 1];
    for (var row : arr) {
      Arrays.fill(row, 0);
    }
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0) {
          arr[i][j] = j;
          continue;
        }
        if (j == 0) {
          arr[i][j] = i;
          continue;
        }
        if (s1.charAt(i - 1) == s2.charAt(i - 1)) {
          arr[i][j] = arr[i - 1][j - 1];
        } else {
          arr[i][j] = 1 + Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));
        }
      }
    }
    return arr[arr.length - 1][arr[0].length - 1];
  }

  public static void main(String[] args) {
    String s1 = "test";
    String s2 = "tet";
    System.out.println(getCount(s1, s2));
  }
}
