class Solution {
  public int minSteps(String s, String t) {
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[t.charAt(i) - 'a']++;
      freq[s.charAt(i) - 'a']--;
    }
    int cont = 0;
    for (int i = 0; i < 26; i++) {
      cont += Math.max(0, freq[i]);
    }
    return cont;
  }
}
