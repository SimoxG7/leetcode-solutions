class Solution {
  public boolean isValid(String word) {
    int n = word.length();
    if (n < 3) return false;
    boolean foundVowel = false, foundConsonant = false;
    for (char c : word.toCharArray()) {
      if (!Character.isLetterOrDigit(c)) return false;
      if (foundVowel && foundConsonant) continue;
      boolean isVowel = isVowel(c);
      if (!foundVowel) foundVowel = isVowel;
      if (!foundConsonant && !Character.isDigit(c)) foundConsonant = !isVowel;
    }
    return foundVowel && foundConsonant;
  }

  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }
}