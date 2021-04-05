import java.util.Arrays;

public class RodCutting {
  public static int getCost(int[] costs, int k) {
    int[] arr = new int[k + 1];
    Arrays.fill(arr, 0);
    arr[0] = 0;
    arr[1] = costs[0];
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j <= i - 1; j++) {
        arr[i] = Math.max(arr[i], costs[j] + arr[i - j - 1]);
      }
    }
    System.out.println(Arrays.toString(arr));
    return arr[arr.length - 1];
  }

  public static void main(String[] args) {
    int length = 4;
    int[] arr = { 21, 56, 18, 9 };
    System.out.println(getCost(arr, length));
  }
}
