class Solution {
	public boolean checkOnesSegment(String s) {
		int n = s.length();
		int count = 0;

		int i = 0;
		while (i < n) {
			if (s.charAt(i) == '1') {
				count++;
				while (i < n && s.charAt(i) == '1')
					i++;
			} else {
				i++;
			}

			if (count > 1)
				return false;
		}

		return true;
	}
}

// import java.util.regex.Pattern;

// class Solution {
// public boolean checkOnesSegment(String s) {
// Pattern pattern = Pattern.compile("1+0+1+");
// return !pattern.matcher(s).find();
// }
// }