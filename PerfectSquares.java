public class PerfectSquares {
  public static int getCount(int num) {
    int result = 0;
    int[] arr = new int[num];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    for (int i = 0; i < arr.length; i++) {
      int currentNum = i + 1;
      if (currentNum == 1 || currentNum == 2 || currentNum == 3) {
        arr[i] = currentNum;
      } else {
        for (int j = 1; j * j <= currentNum; j++) {
          if (j * j == currentNum) {
            arr[i] = 1;
            continue;
          } else {
            arr[i] = Math.min(arr[i], 1 + arr[currentNum - j * j - 1]);
          }
        }
      }
    }
    return arr[arr.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(getCount(18));
  }
}
