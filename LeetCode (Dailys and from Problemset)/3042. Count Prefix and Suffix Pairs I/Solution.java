class Solution {
  public int countPrefixSuffixPairs(String[] words) {
    int n = words.length;
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
      String prefixSuffix = words[i];
      for (int j = i + 1; j < n; j++) {
        if (isPrefixAndSuffix(prefixSuffix, words[j])) count++;
      }
    }
    return count;
  }

  private boolean isPrefixAndSuffix(String prefixSuffix, String container) {
    return container.startsWith(prefixSuffix) && container.endsWith(prefixSuffix);
  }
}