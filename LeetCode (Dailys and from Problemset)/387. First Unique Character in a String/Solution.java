class Solution {
	public int firstUniqChar(String s) {
		int[] cont = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cont[s.charAt(i) - 'a']++;
		} 
		for (int i = 0; i < s.length(); i++) {
			if (cont[s.charAt(i) - 'a'] == 1) return i;
		}
		return -1;
	}	
}