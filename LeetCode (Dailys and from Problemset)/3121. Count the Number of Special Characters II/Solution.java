class Solution {
  public int numberOfSpecialChars(String word) {
    boolean[] lower = new boolean[26];
    boolean[] upper = new boolean[26];
    boolean[] nonSpecial = new boolean[26];

    for (char c : word.toCharArray()) {
      if (Character.isLowerCase(c)) {
        int index = c - 'a';
        if (nonSpecial[index]) continue;
        if (upper[index]) nonSpecial[index] = true;
        lower[index] = true;
      } else {
        int index = c - 'A';
        if (nonSpecial[index]) continue;
        if (!lower[index]) nonSpecial[index] = true;
        upper[index] = true;
      }
    }

    int specials = 0;
    for (int i = 0; i < 26; i++) {
      if (!nonSpecial[i] && lower[i] && upper[i])
        specials++;
    }
    return specials;
  }
}