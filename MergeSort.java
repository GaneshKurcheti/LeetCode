import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {
  public static void merge(int[] arr, int l, int mid, int r) {
    int[] lArr = new int[mid - l + 1];
    int[] rArr = new int[r - mid];
    for (int i = 0; i < lArr.length; i++) {
      lArr[i] = arr[l + i];
    }
    for (int j = 0; j < rArr.length; j++) {
      rArr[j] = arr[mid + 1 + j];
    }
    int i = 0, j = 0;
    int k = l;
    while (i < mid - l + 1 && j < r - mid) {
      if (lArr[i] > rArr[j]) {
        arr[k] = rArr[j];
        j++;
        k++;
      } else if (lArr[i] <= rArr[j]) {
        arr[k] = lArr[i];
        i++;
        k++;
      }
    }
    while (i < mid - l + 1) {
      arr[k] = lArr[i];
      i++;
      k++;
    }
    while (j < r - mid) {
      arr[k] = rArr[j];
      j++;
      k++;
    }
  }

  public static void sortIt(int[] arr, int l, int r) {
    if (l < r) {
      int mid = (l + r) / 2;
      sortIt(arr, l, mid);
      sortIt(arr, mid + 1, r);
      merge(arr, l, mid, r);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 6, 5, 8, 1, 7, 3, 893, 11, 4, 664, 24, 245 };
    sortIt(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

}