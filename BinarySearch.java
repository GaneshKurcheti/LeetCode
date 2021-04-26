import java.util.Arrays;

public class BinarySearch {
  public static int search(int[] arr, int l, int r, int num) {
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] == num) {
        return mid;
      } else if (arr[mid] < num) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] arr, int l, int r, int num) {
    while (l <= r) {
      int mid = l + r / 2;
      if (arr[mid] == num) {
        return mid;
      }
      if (arr[mid] < num) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 6, 5, 8, 1, 7, 3, 893, 11, 4, 664, 24, 245 };
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr) + " " + search(arr, 0, arr.length - 1, 245));
  }
}
