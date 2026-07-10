import java.util.Arrays;

class Solution {
  public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[][] arr = new int[n][2];
    int[] indexMap = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i][0] = nums[i]; // value
      arr[i][1] = i; // index
    }
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i < n; i++) {
      indexMap[arr[i][1]] = i;
    }

    int[] root = new int[n];
    root[0] = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i][0] - arr[i - 1][0] <= maxDiff) {
        root[i] = root[i - 1];
      } else
        root[i] = i;
    }

    int[] next = new int[n];
    int l = 0, r = 0;
    while (l < n) {
      while (r < n && arr[r][0] - arr[l][0] <= maxDiff) {
        r++;
      }
      next[l] = r - 1;
      l++;
    }

    int k = 25; // usually safe for 1e9
    int[][] jump = new int[k][n]; // jump[i][node] denotes where I can reach with 2^i jump from node.

    for (int i = 0; i < n; i++) {
      jump[0][i] = next[i];
    }

    for (int i = 1; i < k; i++) {
      for (int node = 0; node < n; node++) {
        jump[i][node] = jump[i - 1][jump[i - 1][node]];
      }
    }

    int q = queries.length;
    int ans[] = new int[q];
    for (int i = 0; i < q; i++) {
      l = queries[i][0];
      r = queries[i][1];

      int mapL = indexMap[l], mapR = indexMap[r];

      if (root[mapL] != root[mapR]) {
        ans[i] = -1;
        continue;
      }

      if (mapR < mapL) {
        int temp = mapL;
        mapL = mapR;
        mapR = temp;
      }

      if (mapL == mapR) {
        ans[i] = 0;
        continue;
      }
      int jumps = 0;
      for (int base = k - 1; base >= 0; base--) {
        if (jump[base][mapL] < mapR) {
          jumps += (1 << base);
          mapL = jump[base][mapL];
        }
      }

      ans[i] = jumps + 1;
    }

    return ans;
  }
}