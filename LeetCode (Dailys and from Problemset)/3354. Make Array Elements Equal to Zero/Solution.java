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