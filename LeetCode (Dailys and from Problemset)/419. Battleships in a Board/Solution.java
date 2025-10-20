class Solution {
  public int countBattleships(char[][] board) {
    int rows = board.length, cols = board[0].length;
    boolean prevIsShip = board[0][0] == 'X';
    int shipCounter = prevIsShip ? 1 : 0;
    for (int i = 1; i < rows; i++) {
      boolean isShip = board[i][0] == 'X';
      if (isShip && !prevIsShip) shipCounter++;
      prevIsShip = isShip;
    }
    prevIsShip = board[0][0] == 'X';
    for (int i = 1; i < cols; i++) {
      boolean isShip = board[0][i] == 'X';
      if (isShip && !prevIsShip) shipCounter++;
      prevIsShip = isShip;
    }
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (board[i][j] == 'X' && board[i - 1][j] != 'X' && board[i][j - 1] != 'X') shipCounter++;
      }
    }
    return shipCounter;
  }
}