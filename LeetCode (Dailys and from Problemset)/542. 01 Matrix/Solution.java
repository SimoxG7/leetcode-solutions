import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return matrix;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] distances = new int[rows][cols];
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 0) {
          distances[i][j] = 0;
          queue.offer(new int[] { i, j });
        } else {
          distances[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0];
      int y = cell[1];
      for (int[] dir : directions) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
          if (distances[nx][ny] > distances[x][y] + 1) {
            distances[nx][ny] = distances[x][y] + 1;
            queue.offer(new int[] { nx, ny });
          }
        }
      }
    }

    return distances;
  }
}