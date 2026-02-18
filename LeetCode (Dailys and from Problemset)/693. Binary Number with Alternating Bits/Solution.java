class Solution {
  public boolean hasAlternatingBits(int n) {
    int prev = n & 0x1;
    while (n > 0) {
      n >>= 1;
      int lastBit = n & 0x1;
      if (lastBit == prev) return false;
      prev = lastBit;
    }
    return true;
  }
}