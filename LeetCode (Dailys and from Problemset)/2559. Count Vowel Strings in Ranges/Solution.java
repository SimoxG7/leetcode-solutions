class Solution {
  public int[] vowelStrings(String[] words, int[][] queries) {
    int n = words.length;
    int[] cumulativeVowelCount = new int[n];
    for (int i = 0; i < n; i++) {
      cumulativeVowelCount[i] = cumulativeVowelCount[Math.max(i - 1, 0)] + (isVowelEnds(words[i]) ? 1 : 0);
    }
    int q = queries.length;
    int res[] = new int[q];
    for (int i = 0; i < q; i++) {
      if (queries[i][0] == 0) res[i] = cumulativeVowelCount[queries[i][1]];
      else res[i] = cumulativeVowelCount[queries[i][1]] - cumulativeVowelCount[Math.max(queries[i][0] - 1, 0)];
    }
    return res;
  }

  private boolean isVowelEnds(String word) {
    char s = word.charAt(0);
    if (!isVowel(s)) return false;
    char e = word.charAt(word.length() - 1);
    return isVowel(e);
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}