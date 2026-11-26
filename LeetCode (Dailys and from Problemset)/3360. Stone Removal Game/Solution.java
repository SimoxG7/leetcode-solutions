class Solution {
  public boolean canAliceWin(int n) {
    boolean aliceWins = false;
    int currRemove = 10;
    while (n >= currRemove) {
      n -= currRemove--;
      aliceWins = !aliceWins;
    }
    return aliceWins;
  }
}