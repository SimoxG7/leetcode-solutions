class Solution {
  public String clearDigits(String s) {
    StringBuilder stringBuilder = new StringBuilder(s);
    int idx = 0;
    while (idx < stringBuilder.length()) {
      if (Character.isDigit(stringBuilder.charAt(idx))) {
        stringBuilder.deleteCharAt(idx--);
        if (idx >= 0) {
          stringBuilder.deleteCharAt(idx--);
          idx = Math.max(idx, 0);
        }
      } else idx++;
    }
    return stringBuilder.toString();
  }
}