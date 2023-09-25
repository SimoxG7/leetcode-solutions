class Solution {
  public void solve(char[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    int[] delRows = { -1, 0, 1, 0 };
    int[] delCols = { 0, 1, 0, -1 };

    int[][] visited = new int[rows][cols];

    for (int i = 0; i < cols; i++) {
      if (board[0][i] == 'O' && visited[0][i] == 0) {
        dfs(0, i, board, visited, delRows, delCols);
      }
      if (board[rows - 1][i] == 'O' && visited[rows - 1][i] == 0) {
        dfs(rows - 1, i, board, visited, delRows, delCols); 
      }
    }

    for (int i = 0; i < rows; i++) {
      if (board[i][0] == 'O' && visited[i][0] == 0) {
        dfs(i, 0, board, visited, delRows, delCols); 
      }
      if (board[i][cols - 1] == 'O' && visited[i][cols - 1] == 0) {
        dfs(i, cols - 1, board, visited, delRows, delCols); 
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'O' && visited[i][j] == 0) {
          board[i][j] = 'X'; 
        }
      }
    }
  }

  private static void dfs(int row, int col, char[][] board, int[][] visited, int[] delRows, int[] delCols) {
    visited[row][col] = 1; 

    int rows = board.length;
    int cols = board[0].length;

    for (int i = 0; i < 4; i++) {
      int newRow = row + delRows[i];
      int newCol = col + delCols[i];

      if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
          && board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0) {
        dfs(newRow, newCol, board, visited, delRows, delCols); 
      }
    }
  }
}