public class Solution2 {

  private int expandAroundCenter(String s, int sxt, int dxt) {
    int sx = sxt;
    int dx = dxt;

    while(sx >= 0 && dx < s.length() && s.charAt(sx) == s.charAt(dx)) {
      sx--;
      dx++;
    }
    return dx - sx -1;
  }

  public String longestPalindrome(String s) {
    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i+1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1)/2;
        end = i + len/2;
      }
    }
    return s.substring(start, end + 1);
  }
}