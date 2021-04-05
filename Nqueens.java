import java.util.Arrays;

public class Nqueens {
  public static int counter = 0;

  public static boolean isValid(int[][] arr, int i, int j) {
    for (int p = 0; p < i; p++) {
      if (arr[p][j] == 1) {
        return false;
      }
    }
    for (int q = 0; q < j; q++) {
      if (arr[i][q] == 1) {
        return false;
      }
    }
    int k = 1;
    for (int p = i - 1; p >= 0 && k + j < arr.length; p--) {
      if (arr[p][j + k] == 1) {
        return false;
      }
      k++;
    }
    k = 1;
    for (int p = i - 1; p >= 0 && j - k >= 0; p--) {
      if (arr[p][j - k] == 1) {
        return false;
      }
      k++;
    }
    return true;
  }

  public static void countValidPos(int[][] arr, int currentIndex, int res) {
    if (currentIndex == arr.length) {
      System.out.println(Arrays.deepToString(arr));
      counter++;
    }
    for (int i = 0; i < arr[0].length; i++) {
      if (isValid(arr, currentIndex, i)) {
        arr[currentIndex][i] = 1;
        countValidPos(arr, currentIndex + 1, res);
        arr[currentIndex][i] = 0;
      }
    }

  }

  public static void main(String[] args) {
    int num = 5;
    int[][] arr = new int[num][num];
    for (var ar : arr) {
      Arrays.fill(ar, 0);
    }
    countValidPos(arr, 0, 0);
    System.out.println(counter);
  }
}
