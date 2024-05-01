class Solution {
  public String reversePrefix(String word, char ch) {
    int index = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == ch) {
        index = i + 1;
        break;
      }
    }
    return new StringBuilder(word.substring(0, index)).reverse().toString() + word.substring(index);
  }
}