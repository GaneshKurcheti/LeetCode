import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
  public static int calcLargestRectangle(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] lArr = new int[arr.length];
    int[] rArr = new int[arr.length];
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      if (stack.size() != 0) {
        lArr[i] = stack.peek() + 1;
      } else {
        lArr[i] = 0;
      }
      stack.push(i);
    }
    stack = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      if (stack.size() == 0) {
        rArr[i] = arr.length - 1;
      } else {
        rArr[i] = stack.peek() - 1;
      }
      stack.push(i);
    }
    for (int i = 0; i < arr.length; i++) {
      result = Math.max(result, (rArr[i] - lArr[i] + 1) * arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 1, 5, 6, 2, 3 };
    System.out.println(calcLargestRectangle(arr));
  }
}
