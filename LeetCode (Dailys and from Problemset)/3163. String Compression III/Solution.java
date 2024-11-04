class Solution {
  public String compressedString(String word) {
    char prev = word.charAt(0);
    int cnt = 1;
    StringBuilder comp = new StringBuilder();
    for (int i = 1; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c != prev) {
        comp.append(cnt).append(prev);
        prev = c;
        cnt = 1;
      } else if (cnt == 9) {
        comp.append(cnt).append(prev);
        cnt = 1;
      } else {
        cnt++;
      }
    }
    comp.append(cnt).append(prev);
    return comp.toString();
  }
}