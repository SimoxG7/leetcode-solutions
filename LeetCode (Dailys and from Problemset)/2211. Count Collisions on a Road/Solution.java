class Solution {
  public int countCollisions(String directions) {
    int goingRight = 0;
    int collisions = 0;
    boolean obstacleOnLeft = false;
    for (int i = 0; i < directions.length(); i++) {
      char c = directions.charAt(i);
      if (c == 'L') {
        if (goingRight > 0) {
          collisions += 1 + goingRight;
          obstacleOnLeft = true;
        } else if (obstacleOnLeft) {
          collisions++;
        }
        goingRight = 0;
      } else if (c == 'R') {
        goingRight++;
      } else {
        obstacleOnLeft = true;
        if (goingRight > 0) {
          collisions += goingRight;
          goingRight = 0;
        }
      }
    }
    return collisions;
  }
}