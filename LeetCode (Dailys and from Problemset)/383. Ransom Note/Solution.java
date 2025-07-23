class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] occurrences = new int[26];
    for (char c : magazine.toCharArray()) {
      occurrences[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (--occurrences[c - 'a'] < 0) return false;
    }
    return true;
  }
}