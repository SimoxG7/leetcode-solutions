import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] minimumCost(int n, int[][] edges, int[][] query) {
    int parent[] = new int[n], ans[] = new int[query.length];
    Map<Integer, Integer> componentAND = new HashMap<>();

    for (int i = 0; i < n; i++)
      parent[i] = i;
    for (int edge[] : edges)
      union(parent, edge[0], edge[1]);

    for (int edge[] : edges) {
      int rep = find(parent, edge[0]), mask = (1 << 31) - 1;
      componentAND.put(rep, componentAND.getOrDefault(rep, mask) & edge[2]);
    }

    for (int i = 0; i < query.length; i++) {
      int repS = find(parent, query[i][0]), repT = find(parent, query[i][1]);
      ans[i] = repS != repT ? -1 : componentAND.get(repS);
    }
    return ans;
  }

  private int find(int parent[], int i) {
    return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
  }

  private void union(int parent[], int i, int j) {
    parent[find(parent, j)] = find(parent, i);
  }

}