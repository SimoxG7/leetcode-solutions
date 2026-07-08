class Solution {
  public int[] sumAndMultiply(String s, int[][] queries) {
    int n = s.length();
    long[] concat = new long[n];
    long[] prefix = new long[n];
    int[] nonZero = new int[n];
    long[] pow10 = new long[n];
    int MOD = 1_000_000_007;

    pow10[0] = 1;
    for (int i = 1; i < n; i++) {
      pow10[i] = (pow10[i - 1] * 10) % MOD;
    }
    long sum = 0;
    long val = 0;
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      int d = s.charAt(i) - '0';
      if (d != 0) {
        val = (val * 10 + d) % MOD;
        sum += d;
        cnt++;
      }
      prefix[i] = sum;
      concat[i] = val;
      nonZero[i] = cnt;
    }
    int m = queries.length;
    int[] res = new int[m];
    for (int i = 0; i < m; i++) {
      int l = queries[i][0];
      int r = queries[i][1];
      long temp1, temp2;
      int count;
      if (l != 0) {
        count = nonZero[r] - nonZero[l - 1];
        temp1 = (concat[r] - concat[l - 1] * pow10[count] % MOD % MOD + MOD) % MOD;
        temp2 = (prefix[r] - prefix[l - 1]) % MOD;

      } else {
        temp1 = concat[r] % MOD;
        temp2 = prefix[r] % MOD;
      }
      res[i] = (int) (temp1 * temp2 % MOD);
    }
    return res;
  }
}

// class Solution {

// private static final int MOD = 1_000_000_007;
// private static final int MAX_N = 100_001;
// private static final long[] pow10 = new long[MAX_N];

// static {
// pow10[0] = 1;
// for (int i = 1; i < MAX_N; ++i) {
// pow10[i] = (pow10[i - 1] * 10) % MOD;
// }
// }

// public int[] sumAndMultiply(String s, int[][] queries) {
// int n = s.length();
// int[] sum = new int[n + 1];
// long[] prefixConcatenation = new long[n + 1];
// int[] nonZeroCounter = new int[n + 1];

// for (int i = 0; i < n; i++) {
// int digit = s.charAt(i) - '0';
// sum[i + 1] = sum[i] + digit;
// prefixConcatenation[i + 1] = digit > 0 ? (prefixConcatenation[i] * 10 +
// digit) % MOD : prefixConcatenation[i];
// nonZeroCounter[i + 1] = nonZeroCounter[i] + (digit > 0 ? 1 : 0);
// }

// int m = queries.length;
// int[] res = new int[m];

// for (int i = 0; i < m; ++i) {
// int l = queries[i][0];
// int r = queries[i][1] + 1;
// int length = nonZeroCounter[r] - nonZeroCounter[l];
// long concatenationValue = (prefixConcatenation[r] - ((prefixConcatenation[l]
// * pow10[length]) % MOD) + MOD) % MOD;
// long sumValue = sum[r] - sum[l];
// res[i] = (int) ((concatenationValue * sumValue) % MOD);
// }
// return res;
// }
// }