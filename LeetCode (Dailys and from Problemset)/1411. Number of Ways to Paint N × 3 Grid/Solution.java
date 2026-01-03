class Solution {
  public int numOfWays(int n) {
    final int MOD = (int) 1e9 + 7;
    long same = 6L;
    long diff = 6L;
    for (int i = 1; i < n; i++) {
      long newSame = (3 * same + 2 * diff) % MOD;
      long newDiff = (2 * same + 2 * diff) % MOD;
      same = newSame;
      diff = newDiff;
    }

    return (int) ((same + diff) % MOD);
  }
}