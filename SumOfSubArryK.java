import java.util.*;

interface c {
  void hello();

  void test();
}

class A {
  A() {
    System.out.println("SA here");
  }
}

class B extends A {
  B() {
    System.out.println("B here");
  }
}

public class SumOfSubArryK {
  public static int getSumOfSubArr(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int currSum = 0;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      currSum = currSum + arr[i];
      if (currSum == k) {
        // System.out.println("0---" + i);
        count++;
      }
      if (map.containsKey(currSum - k)) {
        // System.out.println(map.get(currSum - k) + 1 + "-----" + i);
        count += map.get(currSum);
        map.put(currSum, map.get(currSum) + 1);
      }
      map.put(currSum, 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 6, 1, 6, -1, -4, -6, 1, 6, 9, 22, 8 };
    int k = 1;
    getSumOfSubArr(arr, k);
    // System.out.println(Arrays.toString(.toArray()));
  }

}
