public class MaximalSquares {
  public static int getLargestArrArea(char[][] matrix) {
    int result = 0;
    int[][] dpMatrix = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int currValue = 0;
        if (i == 0 || j == 0) {
          currValue = Character.getNumericValue(matrix[i][j]);
        } else if (matrix[i][j] == '1') {
          currValue = Math.min(dpMatrix[i - 1][j], Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j - 1])) + 1;
        }
        dpMatrix[i][j] = currValue;
        result = Math.max(currValue, result);
      }
    }

    return result * result;
  }

  public static void main(String[] args) {
    char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' } };
    System.out.println(getLargestArrArea(matrix));
  }

}
