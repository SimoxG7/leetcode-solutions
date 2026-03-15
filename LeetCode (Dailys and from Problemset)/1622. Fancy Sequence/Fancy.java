import java.util.ArrayList;
import java.util.List;

class Fancy {

  private static final long MOD = 1_000_000_007;
  private final List<Long> lst;
  private long mul, add;

  public Fancy() {
    lst = new ArrayList<>();
    mul = 1L;
    add = 0L;
  }

  private long modPow(long a, long b) {
    long res = 1L;
    a %= MOD;

    while (b > 0) {
      if ((b & 1) == 1)
        res = (res * a) % MOD;

      a = (a * a) % MOD;
      b >>= 1;
    }

    return res;
  }

  long modInverse(long x) {
    return modPow(x, MOD - 2L);
  }

  public void append(int val) {
    lst.add(((val - add + MOD) % MOD * modInverse(mul)) % MOD);
  }

  public void addAll(int inc) {
    add = (add + inc) % MOD;
  }

  public void multAll(int m) {
    mul = (mul * m) % MOD;
    add = (add * m) % MOD;
  }

  public int getIndex(int idx) {
    if (idx >= lst.size()) return -1;
    return (int) ((lst.get(idx) * mul + add) % MOD);
  }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */