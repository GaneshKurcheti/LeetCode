
public class BestTimetoBuyAndSellShares {
  public static int profit(int[] arr) {
    int maxProfit = 0;
    int minVal = Integer.MAX_VALUE;
    for (var each : arr) {
      minVal = Math.min(minVal, each);
      maxProfit = Math.max(maxProfit, (each - minVal));
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] arr = { 7, 1, 5, 3, 6, 4 };
    System.out.println(profit(arr));
  }
}
