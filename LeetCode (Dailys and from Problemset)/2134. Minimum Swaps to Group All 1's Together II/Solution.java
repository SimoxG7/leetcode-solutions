class Solution {
  public int minSwaps(int[] nums) {
    int countOnes = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        countOnes++;
      }
    }
    int countZeros = 0;
    for (int i = 0; i < countOnes; i++) {
      if (nums[i] == 0) {
        countZeros++;
      }
    }
    int minZeros = countZeros;
    for (int i = 1; i < nums.length; i++) {
      int start = i;
      int end = (i + countOnes - 1) % nums.length;
      if (nums[end] == 0) {
        countZeros++;
      }
      if (nums[start - 1] == 0) {
        countZeros--;
      }
      minZeros = Math.min(minZeros, countZeros);
    }
    return minZeros;
  }
}