class Solution {
  public int countCharacters(String[] words, String chars) {
    int[] original = new int[26];
    for (int i = 0; i < chars.length(); i++) {
      original[chars.charAt(i) - 'a']++;
    }
    int res = 0;
    for (int i = 0; i < words.length; i++) {
      int[] inner = new int[26];
      for (int j = 0; j < words[i].length(); j++) {
        inner[words[i].charAt(j) - 'a']++;
      }
      boolean broke = false;
      for (int j = 0; j < 26; j++) {
        if (inner[j] > original[j]) {
          broke = true;
          break;
        }
      }
      if (!broke) res += words[i].length();
    }
    return res;
  }
}