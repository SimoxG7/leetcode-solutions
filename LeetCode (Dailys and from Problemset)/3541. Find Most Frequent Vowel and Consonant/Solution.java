class Solution {

  public int maxFreqSum(String s) {
    int[] occurs = new int[26];
    for (int i = 0; i < s.length(); i++) {
      occurs[s.charAt(i) - 'a']++;
    }
    int maxVowel = 0, maxConsonant = 0;
    for (int i = 0; i < 26; i++) {
      if (isVowelIndex(i)) maxVowel = Math.max(maxVowel, occurs[i]);
      else maxConsonant = Math.max(maxConsonant, occurs[i]);
    }
    return maxVowel + maxConsonant;
  }

  private boolean isVowelIndex(int index) {
    return (index == 0 || index == 4 || index == 8 || index == 14 || index == 20);
  }
}
