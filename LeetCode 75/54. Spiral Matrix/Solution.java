import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return res;

    int n = matrix.length, m = matrix[0].length;
    int up = 0, down = n - 1;
    int left = 0, right = m - 1;
    
    while (res.size() < n * m) {
      for (int j = left; j <= right && res.size() < n * m; j++)
        res.add(matrix[up][j]);

      for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
        res.add(matrix[i][right]);

      for (int j = right; j >= left && res.size() < n * m; j--)
        res.add(matrix[down][j]);

      for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
        res.add(matrix[i][left]);

      left++;
      right--;
      up++;
      down--;
    }
    return res;
  }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//   public List<Integer> spiralOrder(int[][] matrix) {
//     List<Integer> res = new ArrayList<>();
//     int n = matrix.length;
//     int m = matrix[0].length;
//     int iteration = 0;

//     while (res.size() < n*m) {
//       for (int i = iteration; i < m - 1 - iteration; i++) {
//         res.add(matrix[iteration][i]);
//       }
//       for (int i = iteration; i < n - 1 - iteration; i++) {
//         res.add(matrix[i][m - iteration - 1]);
//       }
//       for (int i = m - 1 - iteration; i > iteration; i--) {
//         res.add(matrix[n - iteration - 1][i]);
//       }
//       for (int i = n - 1 - iteration; i > iteration; i--) {
//         res.add(matrix[i][iteration]);
//       }
//       iteration++;
//     }
//     return res;
//   }
// }