class Solution {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length;
    int maxSum = 0;
    int[] leftMax = new int[n + 1];
    int[] rightMax = new int[n + 1];
    int[] leftMaxIndex = new int[n + 1];
    int[] rightMaxIndex = new int[n + 1];
    int[] preSum = new int[n + 1];
    int maxResult = 0;
    int[] ans = new int[3];
    for (int i = 1; i <= n; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }

    for (int i = 1, j = k, lowestIndex = 1; j <= n; i++, j++) {
      int sum = preSum[j] - preSum[i - 1];
      if (maxSum < sum) {
        maxSum = sum;
        lowestIndex = i;
      }
      leftMaxIndex[j] = lowestIndex - 1;
      leftMax[j] = maxSum;
    }
    maxSum = 0;
    for (int i = n, j = n - k + 1, lowestIndex = j; j > 0; i--, j--) {
      int sum = preSum[i] - preSum[j - 1];
      if (maxSum <= sum) {
        maxSum = sum;
        lowestIndex = j;
      }
      rightMaxIndex[j] = lowestIndex - 1;
      rightMax[j] = maxSum;
    }

    for (int i = k + 1, j = k + k; j <= n - k; i++, j++) {
      int mid = preSum[j] - preSum[i - 1];
      int sum = leftMax[i - 1] + mid + rightMax[j + 1];
      if (maxResult < sum) {
        maxResult = sum;
        ans[0] = leftMaxIndex[i - 1];
        ans[1] = i - 1;
        ans[2] = rightMaxIndex[j + 1];
      }
    }
    return ans;
  }
}