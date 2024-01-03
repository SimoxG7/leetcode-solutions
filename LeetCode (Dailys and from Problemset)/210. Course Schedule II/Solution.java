import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] pair : prerequisites) {
      int prev = pair[1];
      int next = pair[0];
      graph.get(prev).add(next);
    }

    Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      visited.put(i, 0); // 0 -> unvisited, 1 -> visiting, 2 -> visited
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      if (!topoSort(res, graph, visited, i))
        return new int[0];
    }

    int[] result = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      result[i] = res.get(numCourses - i - 1);
    }
    return result;
  }

  private boolean topoSort(List<Integer> res, List<List<Integer>> graph, Map<Integer, Integer> visited, int i) {
    int visit = visited.get(i);
    if (visit == 2) {
      return true;
    }
    if (visit == 1) {
      return false;
    }

    visited.put(i, 1);
    for (int j : graph.get(i)) {
      if (!topoSort(res, graph, visited, j))
        return false;
    }
    visited.put(i, 2);
    res.add(i);

    return true;
  }
}