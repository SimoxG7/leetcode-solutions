import java.util.Arrays;

class Solution {
  public long maximumImportance(int n, int[][] roads) {
    int[] degree = new int[n];
    for (int[] edge : roads) {
      int u = edge[0];
      int v = edge[1];
      degree[u]++;
      degree[v]++;
    }

    Arrays.sort(degree);
    long ans = 0;
    long val = 1;
    for (int deg : degree) {
      ans += (long) deg * val;
      val++;
    }
    return ans;
  }
}