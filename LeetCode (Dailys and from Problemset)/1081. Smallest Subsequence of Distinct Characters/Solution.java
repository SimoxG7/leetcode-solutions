class Solution {
	public String smallestSubsequence(String s) {
		int[] last = new int[26];
		boolean[] seen = new boolean[26];

		for (int i = 0; i < s.length(); i++)
			last[s.charAt(i) - 'a'] = i;

		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (seen[c - 'a'])
				continue;

			while (res.length() > 0 &&
					res.charAt(res.length() - 1) > c &&
					last[res.charAt(res.length() - 1) - 'a'] > i) {
				seen[res.charAt(res.length() - 1) - 'a'] = false;
				res.deleteCharAt(res.length() - 1);
			}

			res.append(c);
			seen[c - 'a'] = true;
		}

		return res.toString();
	}
}