import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  class DSU {

    private final int[] parent;
    private final int[] rank;
    // private final int size;

    public DSU(int size) {
      // this.size = size;
      this.rank = new int[size];
      parent = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    public int find(int i) {
      int root = parent[i];
      if (parent[root] != root) {
        return parent[i] = find(root);
      }
      return root;
    }

    public void join(int x, int y) {
      int xRoot = find(x), yRoot = find(y);
      if (xRoot == yRoot) return;
      if (rank[xRoot] < rank[yRoot]) {
        parent[xRoot] = yRoot;
      } else if (rank[yRoot] < rank[xRoot]) {
        parent[yRoot] = xRoot;
      } else {
        parent[yRoot] = xRoot;
        rank[xRoot]++;
      }
    }
  }

  public int[] processQueries(int c, int[][] connections, int[][] queries) {
    DSU dsu = new DSU(c + 1);

    for (int[] p : connections) {
      dsu.join(p[0], p[1]);
    }

    boolean[] online = new boolean[c + 1];
    int[] offlineCounts = new int[c + 1];
    Arrays.fill(online, true);
    Map<Integer, Integer> minimumOnlineStations = new HashMap<>();
    for (int[] q : queries) {
      int op = q[0];
      int x = q[1];
      if (op == 2) {
        online[x] = false;
        offlineCounts[x]++;
      }
    }

    for (int i = 1; i <= c; i++) {
      int root = dsu.find(i);
      if (!minimumOnlineStations.containsKey(root)) {
        minimumOnlineStations.put(root, -1);
      }

      int station = minimumOnlineStations.get(root);
      if (online[i]) {
        if (station == -1 || station > i) {
          minimumOnlineStations.put(root, i);
        }
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = queries.length - 1; i >= 0; i--) {
      int op = queries[i][0];
      int x = queries[i][1];
      int root = dsu.find(x);
      int station = minimumOnlineStations.get(root);

      if (op == 1) {
        if (online[x]) {
          ans.add(x);
        } else {
          ans.add(station);
        }
      }

      if (op == 2) {
        if (offlineCounts[x] > 1) {
          offlineCounts[x]--;
        } else {
          online[x] = true;
          if (station == -1 || station > x) {
            minimumOnlineStations.put(root, x);
          }
        }
      }
    }

    Collections.reverse(ans);
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}