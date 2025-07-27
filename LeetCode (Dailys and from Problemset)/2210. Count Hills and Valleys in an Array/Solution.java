class Solution {
  public int countHillValley(int[] nums) {
    int n = nums.length;
    int prev = nums[0];
    int cnt = 0;
    for (int i = 1; i < n - 1; i++) {
      int curr = nums[i], next = nums[i + 1];
      if (curr == next)
        continue;
      if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
        cnt++;
      }
      prev = curr;
    }
    return cnt;
  }
}