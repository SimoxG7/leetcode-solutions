class Solution {
  public String mergeAlternately(String word1, String word2) {
    int len1 = word1.length(), len2 = word2.length();
    int minlen = Math.min(len1, len2);
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < minlen; i++) {
      res.append(word1.charAt(i));
      res.append(word2.charAt(i));
    }
    res.append(word1.substring(minlen, len1));
    res.append(word2.substring(minlen, len2));
    return res.toString();
  }
}