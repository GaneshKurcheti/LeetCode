import java.util.Arrays;
import java.util.Stack;

public class MatrixHigherRectangleArea {
  public static int getMaxAreaRow(int[] arr) {
    System.out.println(Arrays.toString(arr));
    int[] lArr = new int[arr.length];
    int[] rArr = new int[arr.length];
    int max = 0;
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (st.empty()) {
        lArr[i] = 0;
        st.push(i);
      } else {
        while (!st.empty() && arr[st.peek()] >= arr[i]) {
          st.pop();
        }
        if (st.empty()) {
          lArr[i] = 0;
        } else {
          lArr[i] = st.peek();
        }
        st.push(i);
      }
    }
    st = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      if (st.empty()) {
        st.push(i);
        rArr[i] = i;
      } else {
        while (!st.empty() && arr[st.peek()] >= arr[i]) {
          st.pop();
        }
        if (st.empty()) {
          rArr[i] = arr.length - 1;
        } else {
          rArr[i] = st.peek();
        }
        st.push(i);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i] * (rArr[i] - lArr[i]));
    }
    return max;
  }

  public static int getMaxArea(int[][] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 1) {
          arr[i][j] += arr[i - 1][j];
        }
      }
    }
    int result = 0;
    for (var row : arr) {
      result = Math.max(getMaxAreaRow(row), result);
    }
    return result;
  }

  public static void main(String[] arg) {
    int[][] arr = { { 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1 } };
    System.out.println(getMaxArea(arr));
  }
}
