//maybe with diagonal it could be faster?

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    return findInRows(matrix, target, findMaxRowIndex(matrix, target));
  }

  private int findMaxRowIndex(int[][] matrix, int target) {
    int left = 0, right = matrix.length - 1;
    while (left <= right) {
      int mid = (right + left) / 2;
      if (target < matrix[mid][0]) right = mid - 1;
      else if (target > matrix[mid][0]) left = mid + 1;
      else return mid;
    }
    return Math.max(left - 1, 0);
  }

  private boolean findInRows(int[][] matrix, int target, int upperBoundIndex) {
    for (int i = 0; i <= upperBoundIndex; i++) {
      if (findInRow(matrix[i], target)) return true;
    }
    return false;
  }

  private boolean findInRow(int[] row, int target) {
    int left = 0, right = row.length - 1;
    while (left <= right) {
      int mid = (right + left) / 2;
      if (target < row[mid]) right = mid - 1;
      else if (target > row[mid]) left = mid + 1;
      else return true;
    }
    return false;
  }
}