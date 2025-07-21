class Solution {
  public int superPow(int a, int[] b) {
    if (a % 1337 == 0)
      return 0;
    int p = 0;
    for (int i : b)
      p = (p * 10 + i) % 1140;
    if (p == 0)
      p += 1440;
    return modularExponentiation(a, p, 1337);
  }

  public int modularExponentiation(int b, int e, int m) {
    b %= m;
    int ret = 1;
    while (e != 0) {
      if ((e & 1) != 0)
        ret = ret * b % m;
      b = b * b % m;
      e >>= 1;
    }
    return ret;
  }
}