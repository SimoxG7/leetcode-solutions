class Solution {
  public int maxOperations(String s) {
    int cnt1 = 0;
    int i = 0, n = s.length();
    int res = 0;
    while (i < n) {
      if (s.charAt(i) == '1') {
        cnt1++;
        i++;
      } else {
        while (i < n && s.charAt(i) == '0') {
          i++;
        }
        res += cnt1;
      }
    }
    return res;
  }
}