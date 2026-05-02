class Solution {
	public int rotatedDigits(int n) {
		int[] dp = new int[n + 1];
		int count = 0;

		for (int i = 0; i <= n; i++) {
			if (i < 10) {
				switch (i) {
					case 0:
					case 1:
					case 8:
						dp[i] = 1;
						break;
					case 2:
					case 5:
					case 6:
					case 9:
						dp[i] = 2;
						count++;
						break;
					default:
						dp[i] = 0;
						break;
				}
			} else {
				int a = dp[i / 10];
				int b = dp[i % 10];

				if (a == 1 && b == 1) {
					dp[i] = 1;
				} else if (a >= 1 && b >= 1) {
					dp[i] = 2;
					count++;
				} else {
					dp[i] = 0;
				}
			}
		}

		return count;
	}
}