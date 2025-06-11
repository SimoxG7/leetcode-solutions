class Solution {
  public String removeStars(String s) {
    int skip = 0;
    StringBuilder reverse = new StringBuilder();
    for (int i = s.length()-1; i >= 0; i--) {
      if (s.charAt(i) == '*') skip++;
      else if (skip > 0) skip--;
      else reverse.append(s.charAt(i));
    }
    return reverse.reverse().toString();
  }
}