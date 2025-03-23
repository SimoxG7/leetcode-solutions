import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  class DestinationAndCost implements Comparable<DestinationAndCost> {
    int dest;
    long cost;

    public DestinationAndCost(int d, long c) {
      this.dest = d;
      this.cost = c;
    }

    @Override
    public int compareTo(DestinationAndCost other) {
      return (int) (this.cost - other.cost);
    }
  }

  public int countPaths(int n, int[][] roads) {

    long dist[] = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[0] = 0l;

    List<List<DestinationAndCost>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < roads.length; i++) {
      adj.get(roads[i][0]).add(new DestinationAndCost(roads[i][1], (long) roads[i][2]));
      adj.get(roads[i][1]).add(new DestinationAndCost(roads[i][0], (long) roads[i][2]));
    }

    int ways[] = new int[n];
    ways[0] = 1;

    PriorityQueue<DestinationAndCost> pq = new PriorityQueue<>();
    pq.add(new DestinationAndCost(0, 0l));
    while (!pq.isEmpty()) {
      DestinationAndCost p = pq.remove();
      int curr = p.dest;
      for (DestinationAndCost neigh : adj.get(curr)) {
        long dis = neigh.cost;
        int node = neigh.dest;
        long ans = p.cost + dis;

        if (ans < dist[node]) {

          dist[node] = ans;
          ways[node] = ways[curr];
          ways[node] %= 1000000007;
          pq.add(new DestinationAndCost(node, dist[node]));
        }

        else if (ans == dist[node]) {
          ways[node] += ways[curr];
          ways[node] %= 1000000007;
        }
      }
    }

    return ways[n - 1];

  }

}