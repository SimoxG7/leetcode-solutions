import java.util.List;

class Solution {
	public int[] pathsWithMaxScore(List<String> board) {
		int m = board.size();
		int n = board.get(0).length();
		int[][][] dp = new int[m][n][2];
		final int MOD = 1_000_000_007;
		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 } };
		char[][] arr = new char[m][n];

		for (int i = 0; i < m; i++)
			arr[i] = board.get(i).toCharArray();
		arr[0][0] = '0';
		dp[m - 1][n - 1] = new int[] { 1, 1 };
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if ((i == m - 1 && j == n - 1) || arr[i][j] == 'X')
					continue;
				int add = arr[i][j] - '0';
				for (int[] d : dir) {
					int r = i + d[0], c = j + d[1];
					if (r < m && c < n && dp[r][c][0] > 0)
						dp[i][j][0] = Math.max(dp[i][j][0], dp[r][c][0] + add);
				}
				for (int[] d : dir) {
					int r = i + d[0], c = j + d[1];
					if (r < m && c < n && dp[r][c][0] > 0 && dp[i][j][0] == dp[r][c][0] + add)
						dp[i][j][1] = (dp[i][j][1] + dp[r][c][1]) % MOD;
				}
			}
		}
		return new int[] { dp[0][0][0] > 0 ? dp[0][0][0] - 1 : 0, dp[0][0][1] };
	}
}