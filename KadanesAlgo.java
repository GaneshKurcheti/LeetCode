public class KadanesAlgo {
  public static int getLargest(int[] arr) {
    int sum = arr[0];
    int maxSum = arr[0];
    for (int i = 1; i < arr.length; i++) {
      sum = Math.max(arr[i], sum + arr[i]);
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = { -16, 3, -2, 3, 6, 8, -3, 4 - 4, 8, -16 };
    System.out.println(getLargest(arr));
  }
}
