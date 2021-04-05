import java.util.Arrays;

/**
 * Traprainwater
 */
public class Traprainwater {
  public static int trappedWater(int[] arr) {
    int count = 0;
    if (arr.length <= 2) {
      return 0;
    } else if (arr.length == 3) {
      return arr[1] > arr[2] && arr[1] > arr[0] ? 0 : Math.min(arr[0], arr[2]) - arr[1];
    }
    var leftMax = 0;
    var rightMax = 0;
    var lIndex = 0;
    var rIndex = arr.length - 1;
    while (lIndex < rIndex) {
      if (arr[lIndex] > leftMax) {
        leftMax = arr[lIndex];
      }
      if (arr[rIndex] > rightMax) {
        rightMax = arr[rIndex];
      }
      if (arr[rIndex] > arr[lIndex]) {
        count = count + (leftMax - arr[lIndex]);
        lIndex++;
      } else {
        count = count + (rightMax - arr[rIndex]);
        rIndex--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] t = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println(trappedWater(t));
  }
}