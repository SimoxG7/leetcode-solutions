class Solution {
  public int furthestDistanceFromOrigin(String moves) {
    int LCounter = 0, RCounter = 0, JollyCounter = 0;
    for (char c : moves.toCharArray()) {
      switch (c) {
        case 'L' -> LCounter++;
        case 'R' -> RCounter++;
        default -> JollyCounter++;
      }
    }
    return Math.abs(LCounter - RCounter) + JollyCounter;
  }
}