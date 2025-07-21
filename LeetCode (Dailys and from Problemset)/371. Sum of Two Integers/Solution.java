class Solution {
  public int getSum(int a, int b) {
    while (b != 0) {
      int carry = (a & b) << 1; // carry
      a ^= b; // partial sum
      b = carry; // update with carry
    }
    return a;
  }
}