import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  class Pair {
    int node;
    double probability;

    Pair(int node, double probability) {
      this.node = node;
      this.probability = probability;
    }
  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    List<List<Pair>> list = new ArrayList<>();

    for (int i = 0; i < n; i++)
      list.add(new ArrayList<>());

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      double prob = succProb[i];
      list.get(u).add(new Pair(v, prob));
      list.get(v).add(new Pair(u, prob));
    }

    double[] distance = new double[n];
    Arrays.fill(distance, 0.);
    distance[start] = 1;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int curr_node = queue.poll();
      List<Pair> neighbor_list = list.get(curr_node);
      for (Pair pair : neighbor_list) {
        int neighbor = pair.node;
        double prob = pair.probability;
        double new_prob = distance[curr_node] * prob;
        if (new_prob > distance[neighbor]) {
          distance[neighbor] = new_prob;
          queue.add(neighbor);
        }

      }
    }

    return distance[end];
  }
}