class Solution {
  public int maxRotateFunction(int[] nums) {
    int allSum = 0;
    int len = nums.length;
    int rotationResult = 0;
    for (int i = 0; i < len; i++) {
      rotationResult += i * nums[i];
      allSum += nums[i];
    }
    int max = rotationResult;
    for (int i = len - 1; i >= 1; i--) {
      rotationResult = rotationResult + allSum - len * nums[i];
      max = Math.max(rotationResult, max);
    }
    return max;
  }
}

/*
 * Test 1: [1,2,3,4]
 * 
 * F(0) -> 1 * 0 + 2 * 1 + 3 * 2 + 4 * 3 = 20
 * F(1) -> 4 * 0 + 1 * 1 + 2 * 2 + 3 * 3 = 15
 * F(2) -> 3 * 0 + 4 * 1 + 1 * 2 + 2 * 3 = 12
 * F(3) -> 2 * 0 + 3 * 1 + 4 * 2 + 1 * 3 = 14
 * 
 * F(1) -> [0, 2, 6, 12] + []
 * 
 * Max = F(0) = 20
 * 
 * 
 * F(k) -> [k, k + 1, ... , n - 2, n - 1, 0, 1, ... , k - 1] * nums
 * F(k + 1) -> [k + 1, k + 2, ... , n - 1, 0, 1, 2, ... , k] * nums
 * 
 * F(k + 1) - F(k) = [1, 1, 1, ... , -n + 1, 1, 1] * nums
 * 
 * F(K + 1) = [1, 1, 1, ... , -n + 1, 1, 1] * nums + F(k)
 * 
 */