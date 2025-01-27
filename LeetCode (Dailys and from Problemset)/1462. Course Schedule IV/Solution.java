import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    List<Boolean> res = new ArrayList<>();
    boolean adj[][] = new boolean[numCourses][numCourses];
    for (int i[] : prerequisites) {
      adj[i[0]][i[1]] = true;
    }
    for (int k = 0; k < numCourses; k++) {
      for (int i = 0; i < numCourses; i++) {
        for (int j = 0; j < numCourses; j++) {
          adj[i][j] = adj[i][j] | (adj[i][k] & adj[k][j]);
        }
      }
    }
    for (int i[] : queries)
      res.add(adj[i[0]][i[1]]);
    return res;
  }
}