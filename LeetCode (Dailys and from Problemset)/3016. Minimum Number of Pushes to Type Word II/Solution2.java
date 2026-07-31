import java.util.Arrays;

class Solution {
  public int minimumPushes(String word) {
    int[] ans = new int[26];

    for (int i = 0; i < word.length(); i++) {
      int ch = (int) (word.charAt(i) - 'a');
      ans[ch]++;
    }
    Arrays.sort(ans);
    int count = 1;
    int ans1 = 0;
    for (int i = 25; i >= 0; i--) {
      if (ans[i] > 0 && count <= 8) {
        ans1 = ans1 + (1 * ans[i]);
        count++;
      } else if (ans[i] > 0 && (count > 8 && count <= 16)) {
        ans1 = ans1 + (2 * ans[i]);
        count++;
      } else if (ans[i] > 0 && (count > 16 && count <= 24)) {
        ans1 = ans1 + (3 * ans[i]);
        count++;
      } else if (ans[i] > 0 && (count > 24)) {
        ans1 = ans1 + (4 * ans[i]);
        count++;
      }
    }
    return ans1;
  }
}