import java.util.Arrays;

class Solution {
  int MOD = 1000000007;

  public int kInversePairs(int n, int k) {
    int[][] t = new int[1001][1001];
    for (int[] temp : t)
      Arrays.fill(temp, -1);
    return solve(n, k, t);

  }

  public int solve(int n, int k, int[][] t) {
    if (n == 0) {
      return 0;
    }
    if (k == 0) {
      return 1;
    }
    if (t[n][k] != -1) {
      return t[n][k];
    }
    int inv = 0;
    for (int i = 0; i <= Math.min(k, n - 1); i++) {
      inv = (inv + solve(n - 1, k - i, t)) % MOD;
    }
    return t[n][k] = inv;
  }
}