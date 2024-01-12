class Solution {
  public boolean halvesAreAlike(String s) {
    int len = s.length() / 2;
    String s1 = s.substring(0, len);
    String s2 = s.substring(len);
    String vowels = "aeiouAEIOU";
    int c1 = 0, c2 = 0;
    for (int i = 0; i < len; i++) {
      if (vowels.contains(s1.charAt(i) + "")) c1++;
      if (vowels.contains(s2.charAt(i) + "")) c2++;
    }
    return c1 == c2;
  }
}