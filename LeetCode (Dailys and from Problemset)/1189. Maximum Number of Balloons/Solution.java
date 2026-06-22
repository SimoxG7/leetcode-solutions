import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxNumberOfBalloons(String text) {
		final char[] occurringTwice = new char[]{'l', 'o'};
		final char[] occurringOnce = new char[]{'b', 'a', 'n'};

		int[] counter = new int[26];
		for (char c : text.toCharArray()) {
			counter[c - 'a']++;
		}

		int minCommonCount = Integer.MAX_VALUE;
		for (char c : occurringTwice) {
			int occurrences = counter[c - 'a'] >> 1;
			if (occurrences == 0) return 0;
			minCommonCount = Math.min(minCommonCount, occurrences);
		}
		for (char c : occurringOnce) {
			int occurrences = counter[c - 'a'];
			if (occurrences == 0) return 0;
			minCommonCount = Math.min(minCommonCount, occurrences);
		}
		return minCommonCount;
	}
}