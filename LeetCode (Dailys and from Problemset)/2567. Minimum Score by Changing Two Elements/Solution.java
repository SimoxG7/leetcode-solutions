import java.util.Arrays;

class Solution {
	public int minimizeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int max = nums[n - 1] - nums[2];
		max = Math.min(max, nums[n - 2] - nums[1]);
		max = Math.min(max, nums[n - 3] - nums[0]);
		return max;
	}
}