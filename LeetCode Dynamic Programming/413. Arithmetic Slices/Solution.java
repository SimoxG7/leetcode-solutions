class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    if (n < 3)
      return 0;
    int[] temp = new int[2];
    temp[0] = Integer.MAX_VALUE;
    int res = 0;
    for (int i = 1; i + 1 < n; i++) {
      if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
        if (temp[0] == nums[i] - nums[i - 1]) {
          res += temp[1] + 1;
          temp[1]++;
        } else {
          temp[0] = nums[i] - nums[i - 1];
          temp[1] = 1;
          res++;
        }
      } else {
        temp[0] = Integer.MAX_VALUE;
      }
    }
    return res;
  }
}