class Solution {
	public String decodeCiphertext(String encodedText, int rows) {
		if (rows <= 1)
			return encodedText;

		StringBuilder decoded = new StringBuilder();
		int n = encodedText.length();
		int m = n / rows;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < rows; j++) {
				int index = i + j + (m * j);
				if (index < rows * m) {
					decoded.append(encodedText.charAt(index));
				}
			}
		}

		return decoded.toString().stripTrailing();
	}
}