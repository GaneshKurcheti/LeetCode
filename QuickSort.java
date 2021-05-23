import java.util.Arrays;

public class QuickSort {
  public static void QuickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int pValue = arr[end];
    int pivot = end;
    int i = start;
    int j = start;

    while (j < pivot) {
      if (arr[i] < pValue) {
        i++;
        j++;
        continue;
      }
      if (arr[j] <= pValue) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }
      j++;
    }
    arr[pivot] = arr[i];
    arr[i] = pValue;
    QuickSort(arr, start, i - 1);
    QuickSort(arr, i + 1, end);
  }

  public static void main(String[] args) {
    int[] arr = { 104, 86, 17, 48, 2, 93, 34 };
    QuickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
