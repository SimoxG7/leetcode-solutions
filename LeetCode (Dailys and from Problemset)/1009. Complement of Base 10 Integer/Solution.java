class Solution {
  public int bitwiseComplement(int n) {
    if (n == 0) return 1;
    int mask = 0, m = n;
    while (m != 0) {
      mask = (mask << 1) | 0x01;
      m = m >> 1;
    }
    return (~n) & mask;
  }
}

// 1 ^ 1 -> 0
// 0 ^ 1 -> 1