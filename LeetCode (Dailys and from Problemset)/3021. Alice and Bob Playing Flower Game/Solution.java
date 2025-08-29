class Solution {
  public long flowerGame(int n, int m) {
    long oddN = (n + 1L) >> 1;
    long evenN = n >> 1;
    long oddM = (m + 1L) >> 1;
    long evenM = m >> 1;
    return oddN * evenM + evenN * oddM;
  }
}