class Solution {
	public boolean checkString(String s) {
		boolean foundB = false;
		for (char c : s.toCharArray()) {
			if (c == 'b') foundB = true;
			else if (foundB) return false;
		}
		return true;
	}
}