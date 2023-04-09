import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int ret = 0;

    if (source == target)
      return 0;

    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
        buses.add(i);
        map.put(routes[i][j], buses);
      }
    }

    q.offer(source);
    while (!q.isEmpty()) {
      int len = q.size();
      ret++;
      for (int i = 0; i < len; i++) {
        int cur = q.poll();
        ArrayList<Integer> buses = map.get(cur);
        for (int bus : buses) {
          if (visited.contains(bus))
            continue;
          visited.add(bus);
          for (int j = 0; j < routes[bus].length; j++) {
            if (routes[bus][j] == target)
              return ret;
            q.offer(routes[bus][j]);
          }
        }
      }
    }
    return -1;
  }
}