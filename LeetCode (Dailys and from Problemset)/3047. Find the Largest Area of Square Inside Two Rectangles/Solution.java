class Solution {

  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    long res = 0;
    int n = bottomLeft.length;
    for (int i = 0; i < n; i++) {
      int blx1 = bottomLeft[i][0];
      int bly1 = bottomLeft[i][1];
      int trx1 = topRight[i][0];
      int try1 = topRight[i][1];
      for (int j = i + 1; j < n; j++) {
        int blx2 = bottomLeft[j][0];
        int bly2 = bottomLeft[j][1];
        int trx2 = topRight[j][0];
        int try2 = topRight[j][1];
        if (blx2 < trx1 && bly2 < try1 && trx2 > blx1 && try2 > bly1) {
          int x = Math.min(trx1, trx2) - Math.max(blx2, blx1);
          int y = Math.min(try1, try2) - Math.max(bly2, bly1);
          int side = Math.min(x, y);
          res = Math.max(side, res);
        }
      }
    }
    return res * res;
  }
}