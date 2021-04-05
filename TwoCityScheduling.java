import java.util.Arrays;

public class TwoCityScheduling {
  public static int getCost(int[][] arr) {
    int result = 0;
    Arrays.sort(arr, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
    int i = 0;
    int j = arr.length / 2;
    for (; i < arr.length / 2 && j < arr.length; i++, j++) {
      result += arr[i][0] + arr[j][1];
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] arr = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
    System.out.println(getCost(arr));
  }
}
