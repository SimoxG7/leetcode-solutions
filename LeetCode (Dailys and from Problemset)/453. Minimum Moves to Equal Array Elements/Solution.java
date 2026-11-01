class Solution {
	public int minMoves(int[] nums) {
		int n = nums.length;
		if (n == 1) return 0;
		if (n == 2) return Math.abs(nums[0] - nums[1]);

		int min = Integer.MAX_VALUE;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			min = Math.min(min, num);
			sum += num;
		}

		return (int) (sum - (n * min));
	}
}