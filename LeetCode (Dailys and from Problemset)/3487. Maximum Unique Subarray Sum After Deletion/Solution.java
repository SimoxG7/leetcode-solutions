class Solution {
  public int maxSum(int[] nums) {
    boolean[] occurred = new boolean[201];
    int centerIndex = 100;
    for (int num : nums) {
      occurred[num + centerIndex] = true;
    }
    boolean positiveFound = false;
    int sum = 0;
    for (int i = centerIndex; i < 201; i++) {
      if (occurred[i]) {
        positiveFound = true;
        sum += (i - centerIndex);
      }
    }
    if (positiveFound) return sum;
    for (int i = centerIndex - 1; i >= 0; i--) {
      if (occurred[i]) return i - centerIndex;
    }
    return 0; //impossible
  }
}

// import java.util.Collections;
// import java.util.HashSet;
// import java.util.Set;

// class Solution {
// public int maxSum(int[] nums) {
// Set<Integer> negativeSet = new HashSet<>();
// Set<Integer> positiveSet = new HashSet<>();
// for (int i : nums) {
// if (i >= 0) positiveSet.add(i);
// else negativeSet.add(i);
// }
// if (positiveSet.isEmpty()) return Collections.max(negativeSet);
// return positiveSet.stream().reduce(0, (x, y) -> x + y);
// }
// }