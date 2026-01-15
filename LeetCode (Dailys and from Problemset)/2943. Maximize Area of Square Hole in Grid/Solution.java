import java.util.Arrays;

class Solution {
  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);

    int hMax, vMax;

    // Horizontal gap
    if (hBars.length == n) {
      hMax = n + 1;
    } else {
      hMax = getMaxLen(hBars);
    }

    // Vertical gap
    if (vBars.length == m) {
      vMax = m + 1;
    } else {
      vMax = getMaxLen(vBars);
    }

    int minSide = Math.min(hMax, vMax);
    return minSide * minSide;
  }

  private int getMaxLen(int[] sides) {
    int currLen = 1;
    int maxLen = 0;

    for (int i = 0; i < sides.length - 1; i++) {
      if (sides[i] + 1 == sides[i + 1]) {
        currLen++;
      } else {
        maxLen = Math.max(maxLen, currLen);
        currLen = 1;
      }
    }

    maxLen = Math.max(maxLen, currLen);
    return maxLen + 1;
  }
}