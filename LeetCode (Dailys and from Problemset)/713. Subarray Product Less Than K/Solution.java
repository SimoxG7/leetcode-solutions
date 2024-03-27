class Solution {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int left = 0, end = 0, prod = 1, cont = 0;
    while (end < nums.length) {
      prod *= nums[end++]; 
      while (left < end && prod >= k) {
        prod /= nums[left++];
      }
      if (prod < k) {
        cont += end - left;
      }
    }
    return cont;
  }
}