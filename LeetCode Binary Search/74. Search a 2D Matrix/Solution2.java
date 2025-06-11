class Solution2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int cont = matrix.length - 1;
    for (int i = matrix.length - 1; i >= 0; i--) {
      if (matrix[i][0] == target) {
        return true;
      } else if (matrix[i][0] > target) {
        if (cont > i) {
          cont = i;
        }
      } else {
        cont = i;
        break;
      }
    }

    int left = 0;
    int right = matrix[0].length - 1;
    
    while (left <= right) {
      int mid = (left + right) / 2;
      if (matrix[cont][mid] > target) {
        right = mid - 1;
      } else if (matrix[cont][mid] < target) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}