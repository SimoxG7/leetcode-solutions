class Solution {
  public String makeGood(String s) {
    StringBuilder sb = new StringBuilder(s);
    int index = 0;
    while (index < sb.length() - 1) {
      char c1 = sb.charAt(index);
      char c2 = sb.charAt(index + 1);
      if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
        if ((Character.isUpperCase(c1) && Character.isLowerCase(c2)) || (Character.isUpperCase(c2) && Character.isLowerCase(c1))) {
          sb = sb.delete(index, index + 2);
          index = Math.max(-1, index-3);
        }
      }
      index++;
    }
    return sb.toString();
  }
}