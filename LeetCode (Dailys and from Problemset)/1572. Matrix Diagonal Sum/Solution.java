class Solution {
  public int diagonalSum(int[][] mat) {
    // matrix are squared
    int len = mat.length;
    int left = 0, right = len - 1;
    int sum = 0;
    for (int i = 0; i < mat.length; i++) {
      if (left != right) sum += mat[i][left] + mat[i][right];
      else sum += mat[i][left];
      left++;
      right--;
    }
    return sum;
  }
}