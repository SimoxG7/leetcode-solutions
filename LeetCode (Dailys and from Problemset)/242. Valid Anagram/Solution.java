class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int letters = 26;
    int[] sOccur = new int[letters];
    int[] tOccur = new int[letters];
    for (int i = 0; i < s.length(); i++) {
      sOccur[s.charAt(i) - 'a']++;
      tOccur[t.charAt(i) - 'a']++;
    }
    for (int i = 0; i < letters; i++) {
      if (sOccur[i] != tOccur[i]) return false;
    }
    return true;
  }
}