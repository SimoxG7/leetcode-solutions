class Solution {
  long[][] dp = new long[15][10001];
  long[][] pr = new long[15][10001];
  long[] tot = new long[15];
  final long mod = 1000000007;
  int n, mx;

  void get(int la, int cn) {
    tot[cn]++;
    for (int p = 2 * la; p <= mx; p += la)
      get(p, cn + 1);
  }

  public int idealArrays(int n, int mx) {
    this.n = n;
    this.mx = mx;

    for (int i = 1; i <= 10000; i++) {
      dp[1][i] = 1;
      pr[1][i] = i;
    }

    for (int i = 2; i < 15; i++) {
      for (int j = i; j <= 10000; j++) {
        dp[i][j] = pr[i - 1][j - 1];
        pr[i][j] = (dp[i][j] + pr[i][j - 1]) % mod;
      }
    }

    for (int i = 1; i <= mx; i++)
      get(i, 1);

    long ans = mx;
    for (int i = 2; i < 15; i++) {
      ans = (ans + tot[i] * dp[i][n]) % mod;
    }

    return (int) ans;
  }
}