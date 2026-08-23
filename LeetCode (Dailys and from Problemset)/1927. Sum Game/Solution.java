class Solution {
	public boolean sumGame(String num) {
		int n = num.length();
		int halfN = n / 2;

		int left = 0, right = 0;

		for (int i = 0; i < n; i++) {
			char c = num.charAt(i);

			int value;

			if (c == '?') value = 9;
			else value = 2 * (c - '0');

			if (i < halfN) left += value;
			else right += value;
		}

		return left != right;
	}
}