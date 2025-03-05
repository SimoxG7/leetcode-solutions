class Solution {
  public long coloredCells(int n) {
    return 1 + 2L * (n - 1) * n;
  }
}

// class Solution {
//   public long coloredCells(int n) {
//     if (n == 1) return 1;
//     else return (n - 1) * 4 + coloredCells(n - 1);
//   }
// }