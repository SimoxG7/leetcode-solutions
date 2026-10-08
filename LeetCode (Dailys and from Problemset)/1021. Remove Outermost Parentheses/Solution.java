class Solution {
  public String removeOuterParentheses(String s) {
    int open = 0;
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        if (open > 0) sb.append(c);
        open++;
      } else {
        open--;
        if (open > 0) sb.append(c);
      }
    }
    return sb.toString();
  }
}