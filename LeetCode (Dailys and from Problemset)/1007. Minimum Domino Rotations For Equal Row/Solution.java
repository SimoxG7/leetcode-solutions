class Solution {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int rotations = calculateRotations(tops, bottoms, tops[0]);
    if (rotations == -1) rotations = calculateRotations(tops, bottoms, bottoms[0]);
    return rotations;
  }

  private int calculateRotations(int[] tops, int[] bottoms, int number) {
    int rotationsToTop = 0, rotationsToBottom = 0;
    for (int i = 0; i < tops.length; i++) {
      boolean isTopEqual = tops[i] == number, isBottomEqual = bottoms[i] == number;
      if (!isTopEqual && !isBottomEqual) return -1;
      else if (!isBottomEqual) rotationsToBottom++;
      else if (!isTopEqual) rotationsToTop++;
    }
    return Math.min(rotationsToTop, rotationsToBottom);
  }
}