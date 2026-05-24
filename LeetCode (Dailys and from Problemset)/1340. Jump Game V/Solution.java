class Solution {
	public int maxJumps(int[] arr, int d) {
		int n = arr.length;
		int[] dp = new int[n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dfs(arr, d, i, dp));
		}

		return max;
	}

	private int dfs(int[] arr, int d, int i, int[] dp) {
		if (dp[i] != 0) {
			return dp[i];
		}
		int max = 1;
		int n = arr.length;
		for (int j = i + 1; j <= i + d && j < n; j++) {
			if (arr[j] >= arr[i]) {
				break;
			}
			max = Math.max(max, 1 + dfs(arr, d, j, dp));
		}
		for (int j = i - 1; j >= i - d && j >= 0; j--) {
			if (arr[j] >= arr[i]) {
				break;
			}
			max = Math.max(max, 1 + dfs(arr, d, j, dp));
		}
		dp[i] = max;
		return dp[i];
	}
}