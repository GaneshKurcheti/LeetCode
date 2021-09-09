public class WordSearchPractice {

  public static boolean isPresent(int i, int j, int current, char[][] wordArr, String word) {
    if (current == word.length()) {
      return true;
    }
    if (i < 0 || i >= wordArr.length || j < 0 || j >= wordArr[i].length) {
      return false;
    }
    if (wordArr[i][j] == word.charAt(current)) {
      char temp = wordArr[i][j];
      wordArr[i][j] = '$';
      if (isPresent(i + 1, j, current + 1, wordArr, word) || isPresent(i - 1, j, current + 1, wordArr, word)
          || isPresent(i, j - 1, current + 1, wordArr, word) || isPresent(i, j + 1, current + 1, wordArr, word)) {
        return true;
      }
      wordArr[i][j] = temp;

    }
    return false;
  }

  public static boolean doesContains(char[][] wordArr, String word) {
    for (int i = 0; i < wordArr.length; i++) {
      for (int j = 0; j < wordArr[i].length; j++) {
        if (wordArr[i][j] == word.charAt(0) && isPresent(i, j, 0, wordArr, word)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] wordArr = { { 'A', 'B', 'C', 'D' }, { 'B', 'C', 'E', 'F' }, { 'G', 'H', 'I', 'J' } };
    System.out.println(doesContains(wordArr, "ABc"));

  }
}