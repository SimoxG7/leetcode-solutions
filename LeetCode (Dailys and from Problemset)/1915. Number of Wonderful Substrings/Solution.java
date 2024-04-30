public class Solution {
  public long wonderfulSubstrings(String word) {
    long[] freq = new long[1024];
    freq[0] = 1;
    long result = 0;
    char mask = 0;
    for (char ch : word.toCharArray()) {
      mask ^= maskOf(ch);
      result += freq[mask];
      for (char curr = 'a'; curr <= 'j'; curr++) {
        char maskToCheck = (char) (mask ^ maskOf(curr));
        result += freq[maskToCheck];
      }
      freq[mask]++;
    }
    return result;
  }

  private int maskOf(char ch) {
    var val = ch - 'a';
    return 1 << val;
  }
}