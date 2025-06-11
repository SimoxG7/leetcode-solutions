import java.util.ArrayList;
import java.util.List;

class Solution {
  int dfs(List<List<Integer>> al, boolean[] visited, int from) {
    int change = 0;
    visited[from] = true;
    for (var to : al.get(from))
      if (!visited[Math.abs(to)])
        change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
    return change;
  }

  public int minReorder(int n, int[][] connections) {
    List<List<Integer>> al = new ArrayList<>();
    for (int i = 0; i < n; ++i)
      al.add(new ArrayList<>());
    for (var c : connections) {
      al.get(c[0]).add(c[1]);
      al.get(c[1]).add(-c[0]);
    }
    return dfs(al, new boolean[n], 0);
  }
}



// class Solution {
//   public int minReorder(int n, int[][] connections) {
//     boolean[] canReach = new boolean[n];
//     canReach[0] = true;

//     int changes = 0;

//     for (int i = 0; i < connections.length; i++) {
//       if (connections[i][1] == 0)
//         canReach[connections[i][0]] = true;
//     }

//     boolean changed = true;
//     while (changed) {
//       changed = false;
//       for (int i = 0; i < connections.length; i++) {
//         if (!canReach[connections[i][1]] && canReach[connections[i][0]]) {
//           int temp = connections[i][0];
//           connections[i][0] = connections[i][1];
//           connections[i][1] = connections[i][0];        
//           changed = true;
//           changes++;
//         }
//       }
//     }
//     return changes;
//   }
// }