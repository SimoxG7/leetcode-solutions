class Solution {
  public String lexPalindromicPermutation(String s, String target) {
    int n = s.length();

    if (n == 1) return s.compareTo(target) > 0 ? s : "";

    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }

    int key = -1;
    for (int i = 0; i < 26; i++) {
      if (count[i] % 2 != 0) {
        if (n % 2 == 0 || key >= 0)
          return "";
        key = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n / 2; i++) {
      boolean matched = false;
      for (int c = 0; c < 26; c++) {
        if (count[c] >= 2) {
          count[c] -= 2;
          sb.append((char) ('a' + c));

          if (isValid(sb, count, key, target)) {
            matched = true;
            break;
          }

          sb.deleteCharAt(sb.length() - 1);
          count[c] += 2;
        }
      }
      if (!matched)
        return "";
    }

    StringBuilder res = new StringBuilder(sb);
    if (key >= 0)
      res.append((char) ('a' + key));
    res.append(sb.reverse());
    return res.toString();
  }

  private boolean isValid(StringBuilder sb, int[] count, int key, String target) {
    StringBuilder half = new StringBuilder(sb);
    for (int d = 25; d >= 0; d--) {
      for (int i = 0; i < count[d] / 2; i++) {
        half.append((char) ('a' + d));
      }
    }

    StringBuilder full = new StringBuilder(half);
    if (key >= 0)
      full.append((char) ('a' + key));
    full.append(half.reverse());

    return full.toString().compareTo(target) > 0;
  }
}