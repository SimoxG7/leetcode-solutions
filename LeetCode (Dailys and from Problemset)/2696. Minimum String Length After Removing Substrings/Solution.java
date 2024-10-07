class Solution {
  public int minLength(String s) {
    StringBuilder sb = new StringBuilder(s);
    int i = 2;
    while (i <= sb.length()) {
      String sub = sb.substring(i - 2, i);
      if (sub.equals("AB") || sub.equals("CD")) {
        sb.delete(i - 2, i);
        i = Math.max(2, i - 1);
      } else i++;
    }
    return sb.length();
  }
}