import java.util.Arrays;

/**
 * Isands
 */
public class Isands {
  public static void convertIsland(char[][] array, int i, int j) {
    array[i][j] = '0';
    if (i + 1 < array.length && array[i + 1][j] == '1') {
      convertIsland(array, i + 1, j);
    }
    if (i - 1 >= 0 && array[i - 1][j] == '1') {
      convertIsland(array, i - 1, j);
    }
    if (j + 1 < array[0].length && array[i][j + 1] == '1') {
      convertIsland(array, i, j + 1);
    }
    if (j - 1 >= 0 && array[i][j - 1] == '1') {
      convertIsland(array, i, j - 1);
    }
  }

  public static int getIslandsCount(char[][] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        if (array[i][j] == '1') {
          count++;
          convertIsland(array, i, j);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    char[][] array = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '1', '1' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };
    String[] arr = { "543", "132", "1332" };
    System.out.println(Arrays.deepToString(array));
    System.out.println(Arrays.toString(arr));
    System.out.println(getIslandsCount(array));
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    if ((int) '1' > 48) {
      System.out.println('1' - 48);
    }
  }
}