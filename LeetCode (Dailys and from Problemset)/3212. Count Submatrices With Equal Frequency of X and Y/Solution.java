class Solution {
  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] xPrefixSum = new int[m + 1][n + 1];
    int[][] yPrefixSum = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        xPrefixSum[i][j] = xPrefixSum[i - 1][j] + xPrefixSum[i][j - 1] - xPrefixSum[i - 1][j - 1];
        yPrefixSum[i][j] = yPrefixSum[i - 1][j] + yPrefixSum[i][j - 1] - yPrefixSum[i - 1][j - 1];
        
        char currChar = grid[i - 1][j - 1];
        if (currChar == 'X') xPrefixSum[i][j]++;
        else if (currChar == 'Y') yPrefixSum[i][j]++;
      }
    }

    int count = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (xPrefixSum[i][j] > 0 && xPrefixSum[i][j] == yPrefixSum[i][j]) count++;
      }
    }
    
    return count;
  }
}

// class Solution {
// public int numberOfSubmatrices(char[][] grid) {
// int m = grid.length, n = grid[0].length;
// int[][] xPrefixSum = new int[m][n];
// int[][] yPrefixSum = new int[m][n];

// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// int xLeft = j == 0 ? 0 : xPrefixSum[i][j - 1];
// int xUpper = i == 0 ? 0 : xPrefixSum[i - 1][j];
// int xUpperLeft = i == 0 || j == 0 ? 0 : xPrefixSum[i - 1][j - 1];
// int xCurrent = grid[i][j] == 'X' ? 1 : 0;
// xPrefixSum[i][j] = xLeft + xUpper - xUpperLeft + xCurrent;

// int yLeft = j == 0 ? 0 : yPrefixSum[i][j - 1];
// int yUpper = i == 0 ? 0 : yPrefixSum[i - 1][j];
// int yUpperLeft = i == 0 || j == 0 ? 0 : yPrefixSum[i - 1][j - 1];
// int yCurrent = grid[i][j] == 'Y' ? 1 : 0;
// yPrefixSum[i][j] = yLeft + yUpper - yUpperLeft + yCurrent;
// }
// }

// int count = 0;
// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (xPrefixSum[i][j] > 0 && xPrefixSum[i][j] == yPrefixSum[i][j]) count++;
// }
// }
// return count;
// }
// }

// class Solution {

// class PairXY {
// public int x, y;

// public PairXY(){
// this.x = 0;
// this.y = 0;
// }
// }

// private final PairXY DEFAULT_PAIR = new PairXY();

// public int numberOfSubmatrices(char[][] grid) {
// int m = grid.length, n = grid[0].length;
// PairXY[][] counter = new PairXY[m][n];
// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// PairXY left = j == 0 ? DEFAULT_PAIR : counter[i][j - 1];
// PairXY upper = i == 0 ? DEFAULT_PAIR : counter[i - 1][j];
// PairXY upperLeft = i == 0 || j == 0 ? DEFAULT_PAIR : counter[i - 1][j - 1];
// PairXY pair = new PairXY();
// if (grid[i][j] == 'X') pair.x++;
// else if (grid[i][j] == 'Y') pair.y++;
// pair.x += upper.x + left.x - upperLeft.x;
// pair.y += upper.y + left.y - upperLeft.y;
// counter[i][j] = pair;
// }
// }

// int count = 0;
// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (counter[i][j].x > 0 && counter[i][j].x == counter[i][j].y) count++;
// }
// }
// return count;
// }
// }