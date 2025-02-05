class Solution {
  public boolean areAlmostEqual(String s1, String s2) {
    int diffCounter = 0;
    char s1First = '\0';
    char s2First = '\0';
    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 != c2) {
        diffCounter++;
        if (diffCounter == 1) {
          s1First = c1;
          s2First = c2;
        } else if (diffCounter == 2) {
          if (c2 != s1First || c1 != s2First) return false;
        } else if (diffCounter > 2) return false;
      }
    }
    return diffCounter != 1;
  }
}