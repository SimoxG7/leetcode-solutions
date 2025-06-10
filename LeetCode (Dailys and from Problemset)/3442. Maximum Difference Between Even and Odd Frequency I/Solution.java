class Solution {
  public int maxDifference(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    int maxOdd = 0, minEven = Integer.MAX_VALUE;
    for (int freq : count) {
      if (freq == 0) continue;
      if (freq % 2 == 1) maxOdd = Math.max(freq, maxOdd);
      else minEven = Math.min(freq, minEven);
    }
    return maxOdd - minEven;
  }
}