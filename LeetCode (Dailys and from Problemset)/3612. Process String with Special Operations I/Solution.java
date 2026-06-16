class Solution {

	public String processStr(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			switch (c) {
				case '*':
					removeLastCharacter(sb);
					break;
				case '#':
					duplicateCurrentResult(sb);
					break;
				case '%':
					reverseCurrent(sb);
					break;
				default:
					sb.append(c);
			}
		}
		return sb.toString();
	}

	private void removeLastCharacter(StringBuilder sb) {
		int length = sb.length();
		if (length > 0) {
			sb.deleteCharAt(length - 1);
		}
	}

	private void duplicateCurrentResult(StringBuilder sb) {
		sb.repeat(sb, 1);
	}

	private void reverseCurrent(StringBuilder sb) {
		sb.reverse();
	}
}