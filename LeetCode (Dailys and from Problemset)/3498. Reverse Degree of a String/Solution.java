class Solution {
	public int reverseDegree(String s) {
		char[] charArray = s.toCharArray();
		int degree = 0;
		for (int i = 0; i < charArray.length; i++) {
			degree += (i + 1) * (26 - (charArray[i] - 'a'));
		}
		return degree;
	}
}