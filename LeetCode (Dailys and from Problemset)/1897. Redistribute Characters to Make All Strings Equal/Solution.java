class Solution {
  public boolean makeEqual(String[] words) {
    int len = words.length;
    final int LETTERS_SIZE = 26;
    int[] map = new int[LETTERS_SIZE];
    for (int i = 0; i < len; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        map[word.charAt(j) - 'a']++;
      }
    }
    for (int i = 0; i < LETTERS_SIZE; i++) {
      if (map[i] % len != 0) return false;
    }
    return true;
  }
}