import java.util.Arrays;

public class WordSearch {
  public static boolean isAMatch(char[][] wordArr, char[] letters, int i, int j, int current) {
    if (current == letters.length) {
      return true;
    }
    if (i >= wordArr.length || i < 0 || j < 0 || j >= wordArr[0].length) {
      return false;
    }
    if (wordArr[i][j] == letters[current]) {
      char temp = wordArr[i][j];
      wordArr[i][j] = '?';
      if (isAMatch(wordArr, letters, i, j + 1, current + 1) || isAMatch(wordArr, letters, i, j - 1, current + 1)
          || isAMatch(wordArr, letters, i - 1, j, current + 1) || isAMatch(wordArr, letters, i + 1, j, current + 1)) {
        return true;
      }
      wordArr[i][j] = temp;
    }
    return false;
  }

  public static boolean isPresent(char[][] wordArr, String word) {
    char[] letters = word.toCharArray();
    for (int i = 0; i < wordArr.length; i++) {
      for (int j = 0; j < wordArr[i].length; j++) {
        if (wordArr[i][j] == letters[0] && isAMatch(wordArr, letters, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] wordArr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
    // char[][] wordArr = { { 'A' } };
    System.out.println(isPresent(wordArr, "A"));
  }

}
