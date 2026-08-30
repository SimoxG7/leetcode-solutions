class Solution {
	public int minimumDeletions(int[] nums) {
		int n = nums.length;
		if (n == 1) return 1;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int minIndex = -1, maxIndex = -1;

		for (int i = 0; i < n; i++) {
			int num = nums[i];

			if (num < min) {
				min = num;
				minIndex = i;
			}

			if (num > max) {
				max = num;
				maxIndex = i;
			}
		}

		int leftIndex = Math.min(minIndex, maxIndex), rightIndex = Math.max(minIndex, maxIndex);

		int bothFront = rightIndex + 1;
		int frontAndBack = leftIndex + 1 + (n - rightIndex);
		int bothBack = (n - leftIndex);

		return Math.min(bothFront, Math.min(frontAndBack, bothBack));
	}
}