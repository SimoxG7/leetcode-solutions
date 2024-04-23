import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  private ArrayList<Integer> graph[];

  private void addEdge(int a, int b) {
    graph[a].add(b);
    graph[b].add(a);
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> ans = new ArrayList<>();
    if (n == 0)
      return ans;
    if (n == 1) {
      ans.add(0);
      return ans;
    }
    graph = new ArrayList[n];
    int inDegree[] = new int[n];
    for (int i = 0; i < n; i++)
      graph[i] = new ArrayList<>();
    for (var a : edges) {
      addEdge(a[0], a[1]);
      inDegree[a[0]]++;
      inDegree[a[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 1) {
        queue.add(i);
      }
    }
    while (queue.size() != 0) {
      int size = queue.size();
      ans.clear();
      for (int i = 0; i < size; i++) {
        int a = queue.remove();
        ans.add(a);
        for (var x : graph[a]) {
          inDegree[x]--;
          if (inDegree[x] == 1)
            queue.add(x);
        }
      }
    }
    return ans;
  }
}