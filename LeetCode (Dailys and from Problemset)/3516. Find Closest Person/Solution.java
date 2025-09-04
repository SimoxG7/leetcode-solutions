class Solution {
  public int findClosest(int x, int y, int z) {
    int distX = Math.abs(x - z);
    int distY = Math.abs(y - z);
    int diff = distX - distY;
    if (diff == 0) return 0;
    return diff < 0 ? 1 : 2;
  }
}