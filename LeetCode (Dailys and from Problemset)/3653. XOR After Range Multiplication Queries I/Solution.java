class Solution {
	public int xorAfterQueries(int[] nums, int[][] queries) {
		final int MOD = 1_000_000_007;
		for (int[] query : queries) {
			int l = query[0], r = query[1], k = query[2], v = query[3];
			int idx = l;
			while (idx <= r) {
				nums[idx] = (int) (((long) nums[idx] * v) % MOD);
				idx += k;
			}
		}

		int xorAccumulator = 0;
		for (int num : nums) {
			xorAccumulator ^= num;
		}
		return xorAccumulator;
	}
}