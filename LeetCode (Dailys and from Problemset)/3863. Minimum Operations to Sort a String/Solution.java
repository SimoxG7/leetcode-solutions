class Solution {
  public int minOperations(String s) {
    int len = s.length();

    if (len == 2) {
      return s.charAt(0) <= s.charAt(1) ? 0 : -1;
    }

    char[] chars = s.toCharArray();

    if (isSorted(chars)) return 0;

    char minChar = 'z', maxChar = 'a';
    for (int i = 0; i < len; i++) {
      char c = chars[i];
      if (c < minChar) minChar = c;
      if (c > maxChar) maxChar = c;
    }

    if (chars[0] == minChar || chars[len - 1] == maxChar) return 1;

    for (int i = 1; i < len - 1; i++) {
      if (chars[i] == minChar || chars[i] == maxChar) return 2;
    }

    return 3;
  }

  private boolean isSorted(char[] chars) {
    int curr = chars[0];
    for (int i = 1; i < chars.length; i++) {
      if (curr > chars[i]) return false;
      curr = chars[i];
    }
    return true;
  }
}