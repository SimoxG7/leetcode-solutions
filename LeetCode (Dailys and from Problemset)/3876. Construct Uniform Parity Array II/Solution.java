class Solution {
	public boolean uniformArray(int[] nums1) {
		int minOdd = Integer.MAX_VALUE;
		for (int num : nums1) {
			if (num % 2 == 1) {
				minOdd = Math.min(minOdd, num);
			}
		}

		if (minOdd == Integer.MAX_VALUE)
			return true;

		boolean evenCondition = true, oddCondition = true;
		for (int num : nums1) {
			if (num <= minOdd) {
				if (num % 2 == 0) evenCondition = false;
				else oddCondition = false;
			}
		}
		return evenCondition || oddCondition;
	}
}