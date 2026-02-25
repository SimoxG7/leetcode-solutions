import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int[] sortByBits(int[] arr) {
    Integer[] arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(arrInt, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        String s1 = Integer.toBinaryString(o1);
        String s2 = Integer.toBinaryString(o2);
        int s1count = 0, s2count = 0;
        for (int i = 0; i < s1.length(); i++) {
          if (s1.charAt(i) == '1') s1count++;
        }
        for (int i = 0; i < s2.length(); i++) {
          if (s2.charAt(i) == '1') s2count++;
        }
        if (s1count == s2count) {
          return Integer.compare(o1, o2);
        } 
        return (s1count - s2count);
      }
    });

    for (int i = 0; i < arr.length; i++) {
      arr[i] = arrInt[i];
    }

    return arr;
  }
}