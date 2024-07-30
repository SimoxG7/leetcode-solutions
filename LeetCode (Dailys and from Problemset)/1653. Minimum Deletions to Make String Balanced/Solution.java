class Solution {
  public int minimumDeletions(String s) {
    int ans = 0, bCount = 0;
    for (char c : s.toCharArray()) {
      if (c == 'a') {
        ans = Math.min(ans + 1, bCount);
      } else {
        bCount++;
      }
    }
    return ans;
  }
}