class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] parent = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    int[] ans = { 0, 0 };

    for (int[] edge : edges) {
      int p1 = find(parent, edge[0]);
      int p2 = find(parent, edge[1]);
      if (p1 == p2) {
        ans = edge;
      } else {
        parent[p2] = p1;
      }
    }
    return ans;
  }

  private int find(int[] parent, int node) {
    while (parent[node] != node) {
      parent[node] = parent[parent[node]];
      node = parent[node];
    }
    return node;
  }
}