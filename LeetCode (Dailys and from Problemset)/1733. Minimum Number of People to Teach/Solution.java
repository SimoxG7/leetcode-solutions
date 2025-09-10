import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
    int m = languages.length;
    List<Set<Integer>> langSets = new ArrayList<>();
    for (int[] personLangs : languages) {
      Set<Integer> set = new HashSet<>();
      for (int lang : personLangs)
        set.add(lang);
      langSets.add(set);
    }
    Set<Integer> needTeaching = new HashSet<>();
    for (int[] pair : friendships) {
      int u = pair[0] - 1, v = pair[1] - 1;
      Set<Integer> langsU = langSets.get(u), langsV = langSets.get(v);
      boolean canCommunicate = false;
      for (int lang : langsU) {
        if (langsV.contains(lang)) {
          canCommunicate = true;
          break;
        }
      }
      if (!canCommunicate) {
        needTeaching.add(u);
        needTeaching.add(v);
      }
    }
    int minTeach = m + 1;
    for (int lang = 1; lang <= n; lang++) {
      int count = 0;
      for (int person : needTeaching) {
        if (!langSets.get(person).contains(lang)) {
          count++;
        }
      }
      minTeach = Math.min(minTeach, count);
    }

    return minTeach;
  }
}