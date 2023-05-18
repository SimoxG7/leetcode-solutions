import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    List<Integer> res = new ArrayList<>();
    int[] visited = new int[n];
    for (List<Integer> e : edges)
      visited[e.get(1)] = 2;
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0)
        res.add(i);
    }
    return res;
  }
}