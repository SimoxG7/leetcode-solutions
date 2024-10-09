class Solution {
  public int minAddToMakeValid(String s) {
    int bracket = 0;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        bracket++;
      } else {
        bracket--;
      }
      if (bracket < 0) {
        res++;
        bracket++;
      }
    }
    return res + bracket;
  }
}