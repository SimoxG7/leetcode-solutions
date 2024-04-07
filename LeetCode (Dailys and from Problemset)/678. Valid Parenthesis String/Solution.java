class Solution {
  public boolean checkValidString(String s) {
    int stars = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '*':
          count++;
          stars--;
          break;
        case '(':
          count++;
          stars++;
          break;
        case ')':
          count--;
          stars--;
          break;
      }
      if (count < 0) return false;
      else if (stars < 0) stars = 0;
    }
    return stars == 0;
  }
}