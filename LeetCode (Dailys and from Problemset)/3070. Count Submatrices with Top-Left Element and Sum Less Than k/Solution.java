
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
  public int countSubmatrices(int[][] grid, int k) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int upper = i == 0 ? 0 : grid[i - 1][j];
        int left = j == 0 ? 0 : grid[i][j - 1];
        int upperLeft = i == 0 || j == 0 ? 0 : grid[i - 1][j - 1];
        grid[i][j] += upper + left - upperLeft;
      }
    }

    // printMatrix(grid);

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] <= k)
          count++;
        else
          break;
      }
    }
    return count;
  }

  private static <T> void printMatrix(T[][] matrix) {
    if (Objects.isNull(matrix)) {
      System.out.println("null");
      return;
    }

    if (matrix.length == 0 || matrix[0].length == 0) {
      System.out.println("[]");
      return;
    }

    System.out.println(String.join(",\n", Arrays.stream(matrix)
        .map(row -> "[" + String.join(", ", Arrays.stream(row).map(el -> el.toString()).toList()) + "]").toList()));
  }

  private static void printMatrix(int[][] matrix) {
    if (Objects.isNull(matrix)) {
      System.out.println("null");
      return;
    }

    if (matrix.length == 0 || matrix[0].length == 0) {
      System.out.println("[]");
      return;
    }

    System.out.println("[" +
        Arrays.stream(matrix)
            .map(row -> "[" +
                Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "))
                + "]")
            .collect(Collectors.joining(",\n "))
        + "]");
  }
}