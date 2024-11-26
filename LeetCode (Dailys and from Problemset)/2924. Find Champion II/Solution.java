class Solution {
  public int findChampion(int n, int[][] edges) {
    int len = edges.length;
    int[] adj = new int[n];

    for (int i = 0; i < len; i++) {
      adj[edges[i][1]]++;
    }

    int counter = 0, result = -1;

    for (int i = 0; i < n; i++) {
      if (adj[i] == 0) {
        counter++;
        if (counter > 1) {
          return -1;
        }
        if (result == -1) {
          result = i;
        }
      }
    }

    return result;
  }
}