class Solution {
  public int maxDepth(String s) {
    int maxDepth = 0;
    int currDepth = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        currDepth++;
        maxDepth = Math.max(currDepth, maxDepth);
      }
      else if (s.charAt(i) == ')') {
        currDepth--;
      }
    }
    return maxDepth;
  }
}