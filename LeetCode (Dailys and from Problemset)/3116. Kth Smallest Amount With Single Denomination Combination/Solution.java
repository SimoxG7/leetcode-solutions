class Solution {
	public long findKthSmallest(int[] coins, int k) {
		long low = 1;

		int mincoin = coins[0];
		for (int i = 0; i < coins.length; i++) {
			mincoin = Math.min(mincoin, coins[i]);
		}

		long high = (long) mincoin * k;
		long res = high;

		while (low <= high) {

			long mid = low + (high - low) / 2;

			if (helper(coins, mid) >= k) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return res;
	}

	private long helper(int[] coins, long mid) {

		long total = 0;

		for (int mask = 1; mask < (1 << coins.length); mask++) {

			long setbits = 0;
			long lcm = 1;

			for (int j = 0; j < coins.length; j++) {

				if ((mask & (1 << j)) != 0) {
					setbits++;
					lcm = getlcm(lcm, coins[j]);
				}
			}

			// Inclusion-Exclusion
			if (setbits % 2 == 1) {
				total += mid / lcm;
			} else {
				total -= mid / lcm;
			}
		}

		return total;
	}

	private long getlcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	private long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}