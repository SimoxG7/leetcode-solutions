import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

  public int[] separateDigits(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      int x = nums[i];
      while (x > 0) {
        res.add(x % 10);
        x /= 10;
      }
    }

    Collections.reverse(res);
    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      result[i] = res.get(i);
    }
    return result;
  }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
// public int[] separateDigits(int[] nums) {
// int n = nums.length;
// List<Integer> accumulator = new ArrayList<>(n);
// for (int i = 0; i < n; i++) {
// int num = nums[i];
// List<Integer> lowerToHigherDigits = new ArrayList<>();
// while (num > 0) {
// lowerToHigherDigits.add(num % 10);
// num /= 10;
// }
// for (int j = lowerToHigherDigits.size() - 1; j >= 0; j--)
// accumulator.add(lowerToHigherDigits.get(j));
// }
// return accumulator.stream().mapToInt(Integer::intValue).toArray();
// }
// }