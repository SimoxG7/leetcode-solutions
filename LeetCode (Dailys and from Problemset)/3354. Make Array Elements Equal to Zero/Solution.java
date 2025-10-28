class Solution {

  public int countValidSelections(int[] nums) {
    int sum = helper(nums);
    int res = 0, count = 0;
    for (int e : nums) {
      res += e;
      if (res == (sum - res) && e == 0)
        count += 2;
      if (((res - (sum - res)) == 1 || (res - (sum - res)) == -1) && e == 0)
        count++;
    }
    return count;
  }

  public int helper(int[] nums) {
    int ans = 0;
    for (int e : nums)
      ans += e;
    return ans;
  }
}

// class Solution {
//   public int countValidSelections(int[] nums) {
//     int n = nums.length;
//     if (n == 1) return 2;
//     int left = 0, right = 0;
//     int leftIndex = 0, rightIndex = nums.length - 1;
//     while (leftIndex < rightIndex) {
//       if (left <= right) {
//         left += nums[leftIndex++];
//       } else {
//         right += nums[rightIndex--];
//       }
//     }
//     rightIndex++;
//     if (left == 0) return n * 2;
//     int res = 0, zeroesEncountered = 0;
//     while (nums[leftIndex] == 0 && leftIndex > 0) {
//       leftIndex--;
//       zeroesEncountered++;
//     }
//     while (nums[rightIndex] == 0 && rightIndex < n) {
//       rightIndex++;
//       zeroesEncountered++;
//     }
//     if (left == right) {
//       res = zeroesEncountered * 2;
//     } else if (Math.abs(left - right) == 1) {
//       res = zeroesEncountered;
//     }
//     return res;
//   }
// }
