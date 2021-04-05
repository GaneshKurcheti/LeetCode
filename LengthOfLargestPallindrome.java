public class LengthOfLargestPallindrome {
  public static String getMaxPossible(char[] arr, String s, int start, int end) {
    if (arr[start] != arr[end]) {
      return "";
    }
    while (start >= 0 && end < arr.length && arr[start] == arr[end]) {
      start--;
      end++;
    }
    return s.substring(start + 1, end);
  }

  public static String getLargestSubString(String s) {
    char[] arr = s.toCharArray();
    String result = "";
    for (int i = 0; i < s.length() - 1; i++) {
      String odd = getMaxPossible(arr, s, i, i);
      String even = getMaxPossible(arr, s, i, i + 1);
      if (result.length() < odd.length() || result.length() < even.length())
        result = odd.length() > even.length() ? odd : even;
    }
    System.out.println(result);
    return result;
  }

  public static void main(String[] args) {
    String a = "aba";
    System.out.println(getLargestSubString(a));
  }
}
