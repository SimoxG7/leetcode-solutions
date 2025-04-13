class Solution {
  public int countGoodNumbers(long n) {
    int mod = 1_000_000_007;
    long oddCount = n / 2;
    long evenCount = oddCount + n % 2;
    long totEvenCount = binaryPowWithMod(5, evenCount, mod);
    long totOddCount = binaryPowWithMod(4, oddCount, mod);
    return (int) ((totEvenCount * totOddCount) % mod);
  }

  private long binaryPowWithMod(long number, long power, int mod) {
    if (power == 0) return 1;
    long res = binaryPowWithMod(number, power / 2, mod);
    return (res * res * (power % 2 == 1 ? number : 1)) % mod;
  }

  // https://cp-algorithms.com/algebra/binary-exp.html
  // private long binaryPow(long number, long power) {
  //   if (power == 0) return 1;
  //   long res = binaryPow(number, power / 2);
  //   return res * res * (power % 2 == 1 ? number : 1);
  // }
}