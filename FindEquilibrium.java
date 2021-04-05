import java.util.Arrays;

public class FindEquilibrium {
  public static int getEquilibrium(int[] arr) {
    int[] lArr = new int[arr.length];
    int[] rArr = new int[arr.length];
    lArr[0] = arr[0];
    rArr[arr.length - 1] = arr[arr.length - 1];
    for (int i = 1; i < arr.length; i++) {
      lArr[i] = arr[i] + lArr[i - 1];
    }
    for (int i = arr.length - 2; i >= 0; i--) {
      rArr[i] = arr[i] + rArr[i + 1];
    }
    for (int i = 1; i < arr.length - 1; i++) {
      if (lArr[i] == rArr[arr.length - 1 - i] && lArr[i - 1] == rArr[arr.length - i]) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 7, 8, 2, 7, 9, 6, 1, 4 };
    System.out.println(getEquilibrium(arr));
  }
}
