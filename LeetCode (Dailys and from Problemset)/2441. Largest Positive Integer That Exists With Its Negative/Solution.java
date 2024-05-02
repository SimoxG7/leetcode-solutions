class Solution {
  public int findMaxK(int[] nums) {
    boolean[] positives = new boolean[1001];
    boolean[] negatives = new boolean[1001];
    int max = -1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num >= 0) {
        positives[num] = true;
      } else {
        negatives[Math.abs(num)] = true;
      }
      if (positives[Math.abs(num)] && negatives[Math.abs(num)]) max = Math.max(Math.abs(num), max);
    }
    return max;
  }
}