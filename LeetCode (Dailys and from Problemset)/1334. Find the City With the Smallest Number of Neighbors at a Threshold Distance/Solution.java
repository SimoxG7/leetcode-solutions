class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int maxValue = 10001; //to not have overflow
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) dist[i][j] = 0;
        else dist[i][j] = maxValue;
      }
    }

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      dist[edge[0]][edge[1]] = edge[2];
      dist[edge[1]][edge[0]] = edge[2];
    }

    floydWarshall(n, dist);

    int[] reachableCities = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && dist[i][j] <= distanceThreshold) reachableCities[i]++;
      }
    }

    int minReachable = Integer.MAX_VALUE;
    int resultCity = -1;
    for (int i = 0; i < n; i++) {
      if (reachableCities[i] <= minReachable && i > resultCity) {
        minReachable = reachableCities[i];
        resultCity = i;
      }
    }
    
    return resultCity;
  }

  private void floydWarshall(int n, int[][] dist) {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }
}
