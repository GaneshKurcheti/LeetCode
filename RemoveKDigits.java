import java.util.Arrays;
import java.util.Stack;

public class RemoveKDigits {
  public static int getFinalNumber(String number, int removables) {
    char[] numChars = number.toCharArray();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < numChars.length; i++) {
      if (stack.size() == 0) {
        if (Integer.parseInt(numChars[i] + "") != 0) {
          stack.push(Integer.parseInt(numChars[i] + ""));
        }
        continue;
      }
      while (Integer.parseInt(numChars[i] + "") < stack.peek() && removables != 0) {
        stack.pop();
        removables--;
      }
      if (stack.size() > 0 || Integer.parseInt(numChars[i] + "") != 0) {
        stack.push(Integer.parseInt(numChars[i] + ""));
      }
    }
    var arr = stack.toArray();
    String res = "";
    for (var each : arr) {
      res = res + each;
    }
    return Integer.parseInt(res);
  }

  public static void main(String[] args) {
    String number = "1432219";
    int removables = 3;
    System.out.println(getFinalNumber(number, removables));
  }
}
