class Solution {
	public int minimumDistance(String word) {
		int[][][] dp = new int[word.length() + 1][27][27];
		for (int i = word.length() - 1; i >= 0; i--) {
			for (int j = 0; j < 27; j++) {
				for (int k = 0; k < 27; k++) {
					int finger1Move = move(j, word.charAt(i) - 'A');
					int finger2Move = move(k, word.charAt(i) - 'A');
					dp[i][j][k] = Math.min(dp[i + 1][word.charAt(i) - 'A'][k] + finger1Move,
							dp[i + 1][j][word.charAt(i) - 'A'] + finger2Move);
				}
			}
		}

		return dp[0][26][26];
	}

	private int move(int source, int target) {
		if (source == 26)
			return 0;
		int y = source / 6;
		int x = source % 6;
		int y2 = target / 6;
		int x2 = target % 6;
		return Math.abs(y2 - y) + Math.abs(x2 - x);
	}
}