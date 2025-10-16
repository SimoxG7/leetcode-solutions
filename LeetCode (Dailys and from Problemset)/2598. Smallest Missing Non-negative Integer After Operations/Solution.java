class Solution {
  public int findSmallestInteger(int[] nums, int value) {
    int n = nums.length;
    int[] freq = new int[value];
    for (int i = 0; i < n; i++) {
      freq[((nums[i] % value) + value) % value]++;
    }
    int mex = 0;
    while (freq[mex % value] > 0) {
      freq[mex % value]--;
      mex++;
    }
    return mex;
  }
}
