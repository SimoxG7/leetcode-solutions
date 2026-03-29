class Solution {
	public boolean canBeEqual(String s1, String s2) {
		StringBuilder sb1 = new StringBuilder(s1);
		int i = 0, j = 2;

		while (j < 4) {
			if (sb1.charAt(i) != s2.charAt(i)) {
				if (sb1.charAt(j) != s2.charAt(i)) {
					return false;
				}
				char temp = sb1.charAt(j);
				sb1.setCharAt(j, sb1.charAt(i));
				sb1.setCharAt(i, temp);
			}

			i++;
			j++;
		}

		return sb1.toString().equals(s2);
	}
}