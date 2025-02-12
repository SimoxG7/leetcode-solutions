class Solution {
  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] livingBoard = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        livingBoard[i][j] = lives(aliveNeighbors(board, m, n, i, j), board[i][j] == 1);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = livingBoard[i][j] ? 1 : 0;
      }
    }
  }

  private boolean lives(int aliveNeighbours, boolean isAlive) {
    if (!isAlive) return aliveNeighbours == 3;
    if (aliveNeighbours < 2) return false;
    else if (aliveNeighbours == 2 || aliveNeighbours == 3) return true;
    else return false;
  }

  private int aliveNeighbors(int[][] board, int m, int n, int x, int y) {
    int aliveNeighbours = 0;
    for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, m - 1); i++) {
      for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
        aliveNeighbours += board[i][j] & 1;
      }
    }
    aliveNeighbours -= board[x][y] & 1;
    return aliveNeighbours;
  }
}