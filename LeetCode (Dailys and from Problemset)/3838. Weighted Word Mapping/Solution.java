class Solution {
  public String mapWordWeights(String[] words, int[] weights) {
    final int MOD = 26;
    StringBuilder stringBuilder = new StringBuilder();
    for (String word : words) {
      int wordWeight = 0;
      for (char c : word.toCharArray()) {
        wordWeight += weights[c - 'a'];
      }
      stringBuilder.append((char) ('z' - wordWeight % MOD));
    }
    return stringBuilder.toString();
  }
}