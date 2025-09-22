class Solution {
  public int maxFrequencyElements(int[] nums) {
    final int maxValue = 101;
    int[] occurr = new int[maxValue];
    for (int i = 0; i < nums.length; i++) {
      occurr[nums[i]]++;
    }
    int max = -1;
    int mult = 1;
    for (int i = 0; i < maxValue; i++) {
      if (occurr[i] > max) {
        max = occurr[i];
        mult = 1;
      } else if (occurr[i] == max) {
        mult++;
      }
    }
    return max * mult;
  }
}