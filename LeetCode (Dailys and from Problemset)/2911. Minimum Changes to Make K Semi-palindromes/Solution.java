
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	int MAX = 1_000_000;
	int[][][] dp;
	int[][] letterChanges;

	public int minimumChanges(String s, int k) {
		dp = new int[s.length() + 1][s.length() + 1][k + 1];
		letterChanges = new int[s.length()][s.length()];
		letterChanges(s);
		for (int[][] i : dp) {
			for (int[] j : i) {
				Arrays.fill(j, -1);
			}
		}
		return recurse(s, 0, 0, k);
	}

	private int recurse(String s, int i, int j, int k) {
		if (dp[i][j][k] != -1)
			return dp[i][j][k];
		if (k == 1) {
			return dp[i][j][k] = (i == s.length() - 1) ? MAX : letterChanges[i][s.length() - 1];
		}
		if (j == s.length() - 1) {
			return dp[i][j][k] = MAX;
		}
		int cost = MAX;
		if (j - i >= 1) {
			cost = letterChanges[i][j] + recurse(s, j + 1, j + 1, k - 1);
		}
		int cost2 = recurse(s, i, j + 1, k);
		return dp[i][j][k] = Math.min(cost, cost2);
	}

	private void letterChanges(String s) {

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String subs = s.substring(i, j + 1);
				List<Integer> divs = new ArrayList<>();
				divs.add(1);
				for (int d = 2; d * d <= subs.length(); d++) {
					if (subs.length() % d == 0) {
						divs.add(d);
						if (d != subs.length() / d) {
							divs.add(subs.length() / d);
						}
					}
				}
				int minCost = Integer.MAX_VALUE;
				for (int d : divs) {
					StringBuilder[] ls = new StringBuilder[d];
					for (int k = 0; k < ls.length; k++) {
						ls[k] = new StringBuilder();
					}

					for (int st = i; st <= j; st++) {
						ls[st % d].append(s.charAt(st));
					}
					int totalCost = 0;
					for (StringBuilder sb : ls) {
						totalCost += calculateCost(sb);
					}
					minCost = Math.min(totalCost, minCost);
				}
				letterChanges[i][j] = minCost;
			}
		}
	}

	int calculateCost(StringBuilder sb) {
		int i = 0;
		int j = sb.length() - 1;
		int cost = 0;
		while (i < j) {
			if (sb.charAt(i) != sb.charAt(j))
				cost++;
			i++;
			j--;
		}
		return cost;
	}
}