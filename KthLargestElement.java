import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
  public static int getLargest(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
    for (var each : arr) {
      maxHeap.add(each);
    }
    int result = 0;
    while (k != 0) {
      result = maxHeap.poll();
      k--;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 6, 8, 1, 6, 6, 2, 1, 78, 9, 2 };
    System.out.println((getLargest(arr, 1)));
  }
}
