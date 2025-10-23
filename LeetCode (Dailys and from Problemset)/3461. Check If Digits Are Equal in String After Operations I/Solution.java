class Solution {
  public boolean hasSameDigits(String s) {
    int len = s.length();
    if (len < 2) return false;
    StringBuilder stringBuilder = new StringBuilder(s);
    while (stringBuilder.length() > 2) {
      StringBuilder newStringBuilder = new StringBuilder();
      for (int i = 1; i < len; i++) {
        newStringBuilder.append((stringBuilder.charAt(i - 1) + stringBuilder.charAt(i)) % 10);
      }
      stringBuilder = newStringBuilder;
      len--;
    }
    return stringBuilder.charAt(0) == stringBuilder.charAt(1);
  }
}