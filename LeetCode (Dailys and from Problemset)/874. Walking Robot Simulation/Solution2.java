import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
    int xPos = 0, yPos = 0;
    int maxDistance = 0;
    int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; //E, S, W, N
    int[] direction = {0, 1};
    int directionIndex = 3;
    Map<Integer, Set<Integer>> obstaclesFromXtoY = new HashMap<>();
    for (int i = 0; i < obstacles.length; i++) {
      Set<Integer> y = obstaclesFromXtoY.getOrDefault(obstacles[i][0], new HashSet<>());
      y.add(obstacles[i][1]);
      obstaclesFromXtoY.put(obstacles[i][0], y);
    }
    for (int i = 0; i < commands.length; i++) {
      int command = commands[i];
      if (isTurnLeft(command)) {
        directionIndex = findDirection(directions, directionIndex, true);
        direction = directions[directionIndex];
        // System.out.println("Turned left. Direction: " + Arrays.toString(direction));
      } else if (isTurnRight(command)) {
        directionIndex = findDirection(directions, directionIndex, false);
        direction = directions[directionIndex];
        // System.out.println("Turned right. Direction: " + Arrays.toString(direction));
      } else {
        for (int j = 0; j < command; j++) {
          Set<Integer> ySet = obstaclesFromXtoY.get(xPos + direction[0]);
          if (Objects.nonNull(ySet) && ySet.contains(yPos + direction[1])) break;
          xPos += direction[0];
          yPos += direction[1];
          int newDistance = squared(xPos) + squared(yPos);
          maxDistance = Math.max(maxDistance, newDistance);
          // System.out.println("(" + xPos + ", " + yPos + ")");
        }
      }
    }
    return maxDistance;
  }

  private boolean isTurnLeft(int command) { return command == -2; }

  private boolean isTurnRight(int command) { return command == -1; }

  private int squared(int number) { return number * number; }

  private int findDirection(int[][] directions, int directionIndex, boolean toLeft) {
    if (toLeft) {
      directionIndex--;
      if (directionIndex < 0) directionIndex = directions.length - 1;
    } else {
      directionIndex++;
      if (directionIndex > directions.length - 1) directionIndex = 0;
    }
    return directionIndex;
  }

}