import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    final String[] customStrings = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    String[] placements = new String[n];
    List<Integer> scoreOrdered = new ArrayList<>();
    for (int i = 0; i < n; i++) scoreOrdered.add(score[i]);
    Collections.sort(scoreOrdered);
    Collections.reverse(scoreOrdered);
    for (int i = 0; i < n; i++) {
      int index = scoreOrdered.indexOf(score[i]);
      if (index < 3) {
        placements[i] = customStrings[index];
      } else {
        placements[i] = (index + 1) + "";
      }
    }
    return placements;
  }
}