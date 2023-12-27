public class Solution {
  public int minCost(String colorSequence, int[] timeRequired) {
    int n = colorSequence.length();
    char previousColor = 'A';
    int previousTime = 0;
    int currentCost = 0, previousCost = 0;

    for (int i = 1; i <= n; i++) {
      if (colorSequence.charAt(i - 1) == previousColor) {
        currentCost = previousCost + Math.min(timeRequired[i - 1], previousTime);
        previousTime = Math.max(timeRequired[i - 1], previousTime);
      } else {
        currentCost = previousCost;
        previousColor = colorSequence.charAt(i - 1);
        previousTime = timeRequired[i - 1];
      }
      previousCost = currentCost;
    }

    return previousCost;
  }
}
