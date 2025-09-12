class Solution {
  public boolean doesAliceWin(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) return true;
    }
    return false;
  }

  private boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
  }
}