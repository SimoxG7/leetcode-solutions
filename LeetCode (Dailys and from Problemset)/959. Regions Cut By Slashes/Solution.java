class Solution {

  public int regionsBySlashes(String[] grid) {
    int[][] arr = new int[grid.length * 3][grid.length * 3];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].toCharArray().length; j++) {
        if (grid[i].charAt(j) == '/') {
          arr[i * 3][j * 3 + 2] = 1;
          arr[i * 3 + 1][j * 3 + 1] = 1;
          arr[i * 3 + 2][j * 3] = 1;
        } else if (grid[i].charAt(j) == '\\') {
          arr[i * 3][j * 3] = 1;
          arr[i * 3 + 1][j * 3 + 1] = 1;
          arr[i * 3 + 2][j * 3 + 2] = 1;
        }
      }
    }

    int regions = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0) {
          dfs(i, j, arr);
          regions++;
        }
      }
    }

    return regions;
  }

  private void dfs(int i, int j, int[][] arr) {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr.length || arr[i][j] == 1)
      return;
    arr[i][j] = 1;
    dfs(i - 1, j, arr);
    dfs(i + 1, j, arr);
    dfs(i, j - 1, arr);
    dfs(i, j + 1, arr);
  }

}