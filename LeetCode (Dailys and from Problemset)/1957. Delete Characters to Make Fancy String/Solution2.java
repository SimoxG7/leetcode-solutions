class Solution {
  public String makeFancyString(String s) {
    if (s.length() <= 2) return s;
    StringBuilder sb = new StringBuilder();
    boolean previousTwoAreSame;
    char previous = s.charAt(1);
    if (s.charAt(0) == s.charAt(1)) previousTwoAreSame = true;
    else previousTwoAreSame = false;
    sb.append(s.substring(0, 2));
    for (int i = 2; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == previous) {
        if (previousTwoAreSame) {
          continue;
        } else {
          previousTwoAreSame = true;
        }
      } else {
        previous = c;
        previousTwoAreSame = false;
      }
      sb.append(c);
    }
    return sb.toString();
  }
}
