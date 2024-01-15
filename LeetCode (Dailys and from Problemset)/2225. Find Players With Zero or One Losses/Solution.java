import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
  public List<List<Integer>> findWinners(int[][] matches) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> occurrences = new TreeSet<>();
    Map<Integer, Integer> losses = new HashMap<>();
    for (int i = 0; i < matches.length; i++) {
      occurrences.add(matches[i][0]);
      occurrences.add(matches[i][1]);
      losses.put(matches[i][1], losses.getOrDefault(matches[i][1], 0) + 1);
    }
    List<Integer> zeroes = new ArrayList<>();
    List<Integer> ones = new ArrayList<>();
    Iterator<Integer> iterator = occurrences.iterator();
    while (iterator.hasNext()) {
      int p = iterator.next();
      int lossNumber = losses.getOrDefault(p, 0);
      if (lossNumber == 0) zeroes.add(p);
      else if (lossNumber == 1) ones.add(p);
    }
    result.add(zeroes);
    result.add(ones);
    return result;
  }
}