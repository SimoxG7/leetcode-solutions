import java.util.ArrayList;
import java.util.List;

class Solution {
  public int makeConnected(int n, int[][] c) {
    if (c.length < n - 1) return -1;

    List<List<Integer>> ans = new ArrayList<>();
    
    for (int i = 0; i < n + 1; i++) ans.add(new ArrayList<>());
    
    for (int k[] : c) {
      ans.get(k[0]).add(k[1]);
      ans.get(k[1]).add(k[0]);
    }
    
    int res = 0;
    int vis[] = new int[n];
    
    for (int i = 0; i < n; i++)
      if (vis[i] == 0) {
        res++;
        dfs(i, ans, vis);
      }
    return res - 1;
  }

  void dfs(int node, List<List<Integer>> ans, int vis[]) {
    vis[node] = 1;
    for (int k : ans.get(node)) {
      if (vis[k] == 0) dfs(k, ans, vis);
    }
  }
}