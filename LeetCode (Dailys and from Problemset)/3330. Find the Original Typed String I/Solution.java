class Solution {
  public int possibleStringCount(String word) {
    char prev = word.charAt(0);
    int currCharCount = 0;
    int res = 1;
    for (int i = 1; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c != prev) {
        res += currCharCount;
        prev = c;
        currCharCount = 0;
      } else {
        currCharCount++;
      }
    }
    return res + currCharCount;
  }
}