class Solution {
  public int numSteps(String s) {
    int n = s.length(), carry = 0, res = 0;

    for (int i = n - 1; i >= 1; i--) {
      if ((s.charAt(i) - '0' + carry) % 2 == 1) {
        res += 2;
        carry = 1;
      } else {
        res += 1;
      }
    }

    return res + carry;
  }
}