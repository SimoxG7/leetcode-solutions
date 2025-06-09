// Categorize the self-crossing scenarios, there are 3 of them:
// 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
// 2. Fifth line meets first line and works for the lines after
// 3. Sixth line crosses first line and works for the lines after

public class Solution {
  public boolean isSelfCrossing(int[] distance) {
    int l = distance.length;
    if (l <= 3)
      return false;

    for (int i = 3; i < l; i++) {
      if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) return true; // Fourth line crosses first line and onward
      
      if (i >= 4) {
        if (distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) return true; // Fifth line meets first line and onward
      }

      if (i >= 5) {
        if (distance[i - 2] - distance[i - 4] >= 0
            && distance[i] >= distance[i - 2] - distance[i - 4]
            && distance[i - 1] >= distance[i - 3] - distance[i - 5]
            && distance[i - 1] <= distance[i - 3])
          return true; // Sixth line crosses first line and onward
      }
    }
    return false;
  }
}