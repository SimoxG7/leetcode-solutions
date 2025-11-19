class Solution {
  public int findFinalValue(int[] nums, int original) {
    boolean[] indexIsInNums = new boolean[1001];
    for (int i = 0; i < nums.length; i++) indexIsInNums[nums[i]] = true;
    while (original <= 1000 && indexIsInNums[original]) {
      original <<= 1;
    }
    return original;
  }
}

// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//   public int findFinalValue(int[] nums, int original) {
//     Set<Integer> set = new HashSet<>();
//     for (int i = 0; i < nums.length; i++) set.add(nums[i]);
//     while (set.contains(original)) {
//       original <<= 1;
//     }
//     return original;
//   }
// }