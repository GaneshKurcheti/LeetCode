import java.util.*;

public class CndyDistribution {
  public static int getAllCandies(int[] ratings) {
    int result = 0;
    int[] arr = new int[ratings.length];
    Arrays.fill(arr, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        arr[i] = arr[i - 1] + 1;
      }
    }
    int[] rArr = new int[ratings.length];
    Arrays.fill(rArr, 1);
    for (int i = arr.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        rArr[i] = rArr[i + 1] + 1;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Math.max(arr[i], rArr[i]);
      result += arr[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 12, 4, 3, 11, 34, 34, 1, 67 };
    System.out.println(getAllCandies(arr));
  }
}
