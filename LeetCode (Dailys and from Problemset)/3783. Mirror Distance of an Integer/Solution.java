class Solution {
	public int mirrorDistance(int n) {
		return Math.abs(n - reverse(n));
	}

	private int reverse(int val) {
		int res = 0;
		while (val > 0) {
			res = res * 10 + val % 10;
			val = val / 10;
		}
		return res;
	}
}