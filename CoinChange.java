public class CoinChange {
  public static int getCount(int[] coins, int sum) {
    if (sum == 0) {
      return 0;
    }
    int[] arr = new int[sum + 1];
    for (int i = 0; i < arr.length; i++) {
      // arr[i] = Integer.MAX_VALUE;
      arr[i] = sum + 1;
    }
    for (int i = 0; i < arr.length; i++) {
      int currentNum = i;
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] == currentNum) {
          arr[i] = 1;
          break;
        }
        if (coins[j] < currentNum) {
          arr[i] = Math.min(arr[i], 1 + arr[currentNum - coins[j]]);
        }
      }
    }
    return arr[arr.length - 1] == sum + 1 ? -1 : arr[arr.length - 1];
  }

  public static void main(String[] args) {
    int[] coins = { 1, 2, 5, 17 };
    int sum = 17;
    System.out.println(getCount(coins, sum));
  }
}
