import java.util.*;

class Solution {
  public int maxBuilding(int n, int[][] restrictions) {
    List<int[]> list = new ArrayList<>();
    list.add(new int[]{1, 0});

    list.addAll(Arrays.asList(restrictions));

    list.sort(new IDSorter());

    if (list.getLast()[0] != n) {
      list.add(new int[]{n, n - 1});
    }

    int[] prev = list.getFirst();
    for (int i = 1; i < list.size(); i++) {
      int[] curr = list.get(i);
      list.get(i)[1] = Math.min(curr[1], prev[1] + curr[0] - prev[0]);
      prev = curr;
    }

    int[] next = list.getLast();
    for (int i = list.size() - 2; i >= 0; i--) {
      int[] curr = list.get(i);
      list.get(i)[1] = Math.min(curr[1], next[1] + next[0] - curr[0]);
      next = curr;
    }

    int result = 0;
    prev = list.getFirst();
    for (int i = 1; i < list.size(); i++) {
      int[] curr = list.get(i);
      int prevHeight = prev[1];  // height of previous restriction
      int currHeight = curr[1];   // height of current restriction
      int prevId = prev[0]; // id of previous restriction
      int currId = curr[0];   // id of current restriction
      result = Math.max(result, Math.max(prevHeight, currHeight) + (currId - prevId - Math.abs(prevHeight - currHeight)) / 2);
      prev = curr;
    }
    return result;
  }

  static class IDSorter implements Comparator<int[]> {
    @Override
    public int compare(int[] myself, int[] other) {
      return Integer.compare(myself[0], other[0]);
    }
  }
}