class Solution {
  public long minimumSteps(String s) {
    int cnt = 0;
    long res = 0L;

    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        res += i - cnt;
        cnt++;
      }
    }
    return res;
  }
}