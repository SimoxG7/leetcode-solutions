class Solution {
	public int minOperations(int[] nums) {
		int pos = 0, n = nums.length;
		while (nums[pos] != 0)
			pos++;
		boolean inc = true, dec = true;
		for (int i = 0; i < n - 1; i++) {
			if (nums[(pos + i) % n] + 1 != nums[(pos + i + 1) % n])
				inc = false;
			if (nums[(pos - i + n) % n] + 1 != nums[(pos - i - 1 + n) % n])
				dec = false;
		}
		if (inc)
			return Math.min(pos, 1 + n - pos + 1);
		if (dec)
			return Math.min(1 + n - pos - 1, pos + 2);
		return -1;
	}
}