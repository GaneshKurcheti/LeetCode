public class WineProfit {
  public static int[][] globalProfits;

  public static int getMaxProfit(int[] arr, int start, int end, int level, int currentProfit) {
    if (globalProfits[start][end] != 0) {
      return globalProfits[start][end];
    }
    if (start == end) {
      currentProfit = currentProfit + level * arr[start];
      return currentProfit;
    }
    int left = getMaxProfit(arr, start + 1, end, level + 1, currentProfit + (level * arr[start]));
    int right = getMaxProfit(arr, start, end - 1, level + 1, currentProfit + (level * arr[end]));
    globalProfits[start][end] = Math.max(left, right);
    return globalProfits[start][end];

  }

  public static void main(String[] args) {
    int[] arr = { 2, 4, 6, 2, 5 };
    globalProfits = new int[arr.length][arr.length];

    System.out.println(getMaxProfit(arr, 0, arr.length - 1, 1, 0));
    // System.out.println(globalProfit);
  }

}
