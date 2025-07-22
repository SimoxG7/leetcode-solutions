class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int left = matrix[0][0], right = matrix[m - 1][n - 1], res = -1;
    while (left <= right) {
      int mid = (left + right) >> 1;
      if (countLessOrEqual(matrix, mid, m, n) >= k) {
        res = mid;
        right = mid - 1;
      } else
        left = mid + 1;
    }
    return res;
  }

  int countLessOrEqual(int[][] matrix, int x, int m, int n) {
    int count = 0, col = n - 1;
    for (int row = 0; row < m; row++) {
      while (col >= 0 && matrix[row][col] > x) col--;
      count += (col + 1);
    }
    return count;
  }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// class Solution {
// public int kthSmallest(int[][] matrix, int k) {
// List<Integer> lst = new ArrayList<>();
// int n = matrix.length;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// lst.add(matrix[i][j]);
// }
// }
// Collections.sort(lst);
// return lst.get(k - 1);
// }
// }