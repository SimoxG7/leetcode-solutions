class Solution {
  public char findTheDifference(String s, String t) {
    int[] occurrences = new int[26];
    for (int i = 0; i < s.length(); i++) {
      occurrences[s.charAt(i) - 'a']++;
      occurrences[t.charAt(i) - 'a']++;
    }
    occurrences[t.charAt(s.length()) - 'a']++;
    for (int i = 0; i < occurrences.length; i++) {
      if (occurrences[i] % 2 != 0) return (char) ('a' + i);
    }
    return 0;
  }
}