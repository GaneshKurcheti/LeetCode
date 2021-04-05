import java.lang.reflect.Array;
import java.util.Arrays;

public class RearrangeArray {
  public static int[] getArr(int[] arr) {
    int[] res = new int[arr.length];
    int i = 0;
    int j = arr.length - 1;
    int k = 0;
    while (i <= j) {
      if (k % 2 == 0) {
        res[k] = arr[i];
        i++;
      } else {
        res[k] = arr[j];
        j--;
      }
      k++;
    }
    return res;

  }

  public static void main(String[] args) {
    int[] arr = { 9, 8, 6, 4, 3 };
    System.out.println(Arrays.toString(getArr(arr)));
  }
}
