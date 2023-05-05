class Solution {
  public int maxVowels(String s, int k) {
    int max = 0;
    int vowelcount = 0; 
    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) vowelcount++;
    }
    max = vowelcount;
    for (int i = k; i < s.length(); i++) {
      if (isVowel(s.charAt(i - k))) vowelcount--;
      if (isVowel(s.charAt(i))) vowelcount++;
      max = Math.max(max, vowelcount);
    }
    return max;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}