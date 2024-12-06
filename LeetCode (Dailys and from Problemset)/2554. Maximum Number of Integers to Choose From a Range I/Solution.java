import java.util.HashSet;
import java.util.Set;

class Solution {
  public int maxCount(int[] banned, int n, int maxSum) {
    Set<Integer> bannedSet = new HashSet<>();
    for (int num : banned) {
      bannedSet.add(num);
    }

    int sum = 0, count = 0;
    for (int i = 1; i <= n; i++) {
      if (!bannedSet.contains(i) && sum + i <= maxSum) { // Skip banned numbers
        sum += i;
        count++;
      }
    }

    return count;
  }
}