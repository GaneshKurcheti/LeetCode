import java.util.Arrays;

public class LongestIncreasingSubSequence {
  public static int getCount(int[] nums) {
    int[] arr = new int[nums.length];
    Arrays.fill(arr, 1);
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          arr[i] = Math.max(arr[i], arr[j] + 1);
          result = Math.max(arr[i], result);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 5, 7, 1, 2 };
    System.out.println(getCount(arr));
  }
}
