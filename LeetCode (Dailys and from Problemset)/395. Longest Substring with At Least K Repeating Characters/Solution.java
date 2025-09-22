import java.util.Arrays;

class Solution {
  public int longestSubstring(String s, int k) {
    int maxUnqiueCharCount = getUniqueCharCount(s);
    int[] freqMap = new int[26];
    int result = 0;

    for (int currentUniqueChar = 1; currentUniqueChar <= maxUnqiueCharCount; currentUniqueChar++) {
      Arrays.fill(freqMap, 0);
      int uniqueCount = 0, countAtLeastK = 0, windowStart = 0, windowEnd = 0;

      while (windowEnd < s.length()) {
        if (uniqueCount <= currentUniqueChar) {
          int idx = s.charAt(windowEnd) - 'a';
          if (freqMap[idx] == 0)
            uniqueCount++;
          freqMap[idx]++;
          if (freqMap[idx] == k)
            countAtLeastK++;
          windowEnd++;
        } else {
          // We need to shrink
          int idx = s.charAt(windowStart) - 'a';
          if (freqMap[idx] == k)
            countAtLeastK--;
          freqMap[idx]--;
          if (freqMap[idx] == 0)
            uniqueCount--;
          windowStart++;
        }
        if (uniqueCount == currentUniqueChar && uniqueCount == countAtLeastK)
          result = Math.max(windowEnd - windowStart, result);
      }
    }
    return result;
  }

  private int getUniqueCharCount(String s) {
    boolean[] chars = new boolean[26];
    int uniqueCount = 0;

    for (char ch : s.toCharArray()) {
      int idx = ch - 'a';
      if (!chars[idx]) {
        uniqueCount++;
        chars[idx] = true;
      }
    }

    return uniqueCount;
  }
}