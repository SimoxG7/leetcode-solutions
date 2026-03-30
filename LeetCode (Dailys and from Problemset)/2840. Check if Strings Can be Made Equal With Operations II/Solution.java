class Solution {

	public boolean checkStrings(String s1, String s2) {
		int[][] freq = new int[26][2];

		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a'][i % 2]++;
			freq[s2.charAt(i) - 'a'][i % 2]--;
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i][0] != 0 || freq[i][1] != 0) {
				return false;
			}
		}

		return true;
	}
}
