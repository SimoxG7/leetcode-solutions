class Solution {
	public int[] leftRightDifference(int[] nums) {
		int leftSum = 0, rightSum = 0, n = nums.length;
		for (int num : nums) {
			rightSum += num;
		}
		for (int i = 0; i < n; i++) {
			int val = nums[i];
			rightSum -= val;
			nums[i] = Math.abs(leftSum - rightSum);
			leftSum += val;
		}
		return nums;
	}
}

// class Solution {
// public int[] leftRightDifference(int[] nums) {
// int n = nums.length;

// int[] leftSum = new int[n];
// for (int i = 1; i < n; i++) {
// leftSum[i] += nums[i - 1] + leftSum[i - 1];
// }

// int[] rightSum = new int[n];
// for (int i = n - 2; i >= 0; i--) {
// rightSum[i] += nums[i + 1] + rightSum[i + 1];
// }

// for (int i = 0; i < n; i++) {
// nums[i] = Math.abs(leftSum[i] - rightSum[i]);
// }
// return nums;

// // int[] result = new int[n];
// // for (int i = 0; i < n; i++) {
// // result[i] = Math.abs(leftSum[i] - rightSum[i]);
// // }
// // return result;
// }
// }