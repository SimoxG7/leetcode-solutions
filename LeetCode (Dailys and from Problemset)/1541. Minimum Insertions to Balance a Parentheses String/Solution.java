class Solution {
  public int minInsertions(String s) {
    int openCount = 0;
    int openNeeded = 0;
    int n = s.length();
    int i = 0;

    while (i < n) {
      if (s.charAt(i) == '(') {
        openCount++;
        i++;
      } else {
        if (i + 1 < n && s.charAt(i + 1) == ')') {
          i += 2;
        } else {
          openNeeded++;
          i++;
        }

        if (openCount > 0) {
          openCount--;
        } else {
          openNeeded++;
        }
      }
    }

    return openNeeded + openCount * 2;
  }
}