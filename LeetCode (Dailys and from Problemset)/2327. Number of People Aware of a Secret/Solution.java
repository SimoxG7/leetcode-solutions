class Solution {
	public int peopleAwareOfSecret(int n, int delay, int forget) {
		long MOD = (long) 1e9 + 7;
		long[] dp = new long[n + 1];
		dp[1] = 1;

		long share = 0;
		for (int d = 2; d <= n; d++) {
			if (d - delay > 0) {
				share = (share + dp[d - delay] + MOD) % MOD;
			}
			if (d - forget > 0) {
				share = (share - dp[d - forget] + MOD) % MOD;
			}
			dp[d] = share;
		}

		long know = 0;
		for (int i = n - forget + 1; i <= n; i++) {
			know = (know + dp[i]) % MOD;
		}

		return (int) know;
	}
}