class Solution {
  public int maxProductPath(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    long res = picker(n - 1, m - 1, 1, grid);
    return res < 0 ? -1 : (int) (res % 1000000007);
  }

  private long picker(int n, int m, long prod, int[][] grid) {
    if (n == 0 && m == 0)
      return prod * grid[0][0];
    if (prod == 0)
      return 0;

    long up = (n != 0) ? picker(n - 1, m, prod * grid[n][m], grid) : Long.MIN_VALUE;
    long left = (m != 0) ? picker(n, m - 1, prod * grid[n][m], grid) : Long.MIN_VALUE;

    return Math.max(up, left);
  }
}