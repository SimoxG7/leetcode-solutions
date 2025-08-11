class Solution {
  public int[] productQueries(int n, int[][] queries) {
    
    // extract bits
    boolean[] bits = new boolean[32];
    int newN = n, cnt = 0;
    for (int i = 31; i >= 0; i--) {
      bits[i] = (newN & 1) == 1;
      if (bits[i]) cnt++;
      newN >>= 1;
    }

    // extract powers
    int[] powers = new int[cnt];
    int idx = 0, currPower = 1;
    for (int i = 31; i >= 0; i--) {
      if (bits[i]) {
        powers[idx++] = currPower;
      }
      currPower <<= 1;
    }

    // apply queries
    int queriesLen = queries.length, mod = (int) 1e9 + 7;
    int[] answers = new int[queriesLen];
    for (int i = 0; i < queriesLen; i++) {
      int[] query = queries[i];
      int left = query[0], right = query[1];
      long acc = powers[left];
      for (int j = left + 1; j <= right; j++) {
        acc *= powers[j];
        acc %= mod;
      }
      answers[i] = (int) acc;
    }
    return answers;
  }
}