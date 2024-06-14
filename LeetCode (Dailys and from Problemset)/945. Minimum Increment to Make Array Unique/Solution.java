class Solution {
  public int minIncrementForUnique(int[] nums) {
    int n = nums.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, nums[i]);
    }
    int freq[] = new int[max + 1];
    for (int i = 0; i < n; i++) {
      freq[nums[i]]++;
    }
    int j = 0;
    for (int i = 0; i < max + 1; i++) {
      while (freq[i] > 0) {
        nums[j] = i;
        j++;
        freq[i]--;
      }
    }
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i] <= nums[i - 1]) {
        int difference = Math.abs(nums[i] - nums[i - 1]) + 1;
        count += difference;
        nums[i] += difference;
      }
    }
    return count;
  }
}