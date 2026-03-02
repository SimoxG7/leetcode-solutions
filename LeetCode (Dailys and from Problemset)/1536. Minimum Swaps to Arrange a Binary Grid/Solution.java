class Solution {
  public int minSwaps(int[][] grid) {
    int n = grid.length;
    int suffix[] = new int[n];
    if (n == 1) {
      return 0;
    }
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = n - 1; j >= 0; j--) {
        if (grid[i][j] == 0) {
          count++;
        } else {
          break;
        }
      }
      suffix[i] = count;
    }
    int ans[] = new int[1];
    for (int i = 0; i < n - 1; i++) {
      int zero = n - 1 - i;
      if (suffix[i] < zero) {
        int ind = -1;
        for (int j = i + 1; j < n; j++) {
          if (suffix[j] >= zero) {
            ind = j;
            break;
          }
        }
        if (ind == -1) {
          return -1;
        }
        swap(i, ind, ans, suffix);
      }
    }
    return ans[0];
  }

  private void swap(int start, int end, int ans[], int suffix[]) {
    while (end > start) {
      int temp = suffix[end];
      suffix[end] = suffix[end - 1];
      suffix[end - 1] = temp;
      ans[0]++;
      end--;
    }
  }
}