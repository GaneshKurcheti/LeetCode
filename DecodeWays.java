import javax.naming.spi.DirStateFactory.Result;

public class DecodeWays {
  public static int getDecodableCounts(String s) {
    if (s.charAt(0) == '0' || s.length() == 0) {
      return 0;
    }
    int[] resArr = new int[s.length()];
    resArr[0] = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '0'
          && (Character.getNumericValue(s.charAt(i - 1)) < 1 || Character.getNumericValue(s.charAt(i - 1)) > 2)) {
        return 0;
      } else if (s.charAt(i) == '0') {
        resArr[i] = i - 2 >= 0 ? resArr[i - 2] : 1;
      } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
        resArr[i] = (i - 2 >= 0 ? resArr[i - 2] : 1) + resArr[i - 1];
      } else {
        resArr[i] = resArr[i - 1];
      }
    }
    return resArr[s.length() - 1];
  }

  public static void main(String[] args) {
    String s = "12342";

    System.out.println(getDecodableCounts(s));
  }
}
