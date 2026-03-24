import java.util.Arrays;

class Solution {
  public int[][] constructProductMatrix(int[][] grid) {
    final int MODULO = 12345;
    int m = grid.length, n = grid[0].length;
    int size = m * n;
    int[] flattenedGrid = new int[size];

    int index = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        flattenedGrid[index++] = grid[i][j];

    int[] prefix = new int[size];
    int[] suffix = new int[size];

    Arrays.fill(prefix, 1);
    Arrays.fill(suffix, 1);

    for (int i = 1; i < size; i++)
      prefix[i] = (int) ((1L * prefix[i - 1] * flattenedGrid[i - 1]) % MODULO);

    for (int i = size - 2; i >= 0; i--)
      suffix[i] = (int) ((1L * flattenedGrid[i + 1] * suffix[i + 1]) % MODULO);

    int[] flattenedProductMatrix = new int[size];
    for (int i = 0; i < size; i++)
      flattenedProductMatrix[i] = (int) ((1L * prefix[i] * suffix[i]) % MODULO);

    int[][] productMatrix = new int[m][n];
    index = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        productMatrix[i][j] = flattenedProductMatrix[index++];

    return productMatrix;
  }
}