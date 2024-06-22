import java.util.Arrays;

class Solution {
  public int maxDistance(int[] position, int m) {
    long left = 0, right = 0;
    for (var pos : position)
      right = Math.max(right, pos);
    long maxForce = 0;
    Arrays.sort(position);
    while (left <= right) {
      long propForce = left + (right - left) / 2;
      if (isGoodProp(propForce, position, m)) {
        maxForce = propForce;
        left = propForce + 1;
      } else {
        right = propForce - 1;
      }
    }
    return (int) maxForce;
  }

  private boolean isGoodProp(long propForce, int[] position, int reqBalls) {
    int ballCnt = 0, prevPos = -1;
    for (var pos : position) {
      if (prevPos == -1 || ((pos - prevPos) * 1l) >= propForce) {
        ballCnt++;
        prevPos = pos;
      }
    }
    return ballCnt >= reqBalls;
  }
}