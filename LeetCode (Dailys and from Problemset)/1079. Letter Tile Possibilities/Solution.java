class Solution {
  public int numTilePossibilities(String tiles) {
    int[] counter = new int[26];
    for (char c : tiles.toCharArray()) {
      counter[c - 'A']++;
    }
    return dfs(counter);
  }

  private int dfs(int[] counter) {
    int possibleSequences = 0;

    for (int i = 0; i < 26; ++i) {
      if (counter[i] == 0) continue;
      counter[i]--;
      possibleSequences += 1 + dfs(counter);
      counter[i]++;
    }

    return possibleSequences;
  }
}