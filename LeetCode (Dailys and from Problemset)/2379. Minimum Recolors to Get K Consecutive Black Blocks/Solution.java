class Solution {
  public int minimumRecolors(String blocks, int k) {
    int whiteChars = 0, res = Integer.MAX_VALUE;
    for (int i = 0; i < blocks.length(); i++) {
      char c = blocks.charAt(i);
      if (c == 'W')
        whiteChars++;
      if (i < (k - 1))
        continue;
      res = Math.min(res, whiteChars);
      if (blocks.charAt(i - (k - 1)) == 'W')
        whiteChars--;
    }
    return res;
  }
}
