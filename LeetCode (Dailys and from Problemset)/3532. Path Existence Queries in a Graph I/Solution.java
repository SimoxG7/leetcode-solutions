class Solution {
  public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[] connectionGroupIds = new int[n];
    int groupId = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i] - nums[i - 1] > maxDiff)
        groupId++;
      connectionGroupIds[i] = groupId;
    }
    
    int m = queries.length;
    boolean[] res = new boolean[m];
    for (int i = 0; i < m; i++) {
      int l = queries[i][0], r = queries[i][1];
      res[i] = connectionGroupIds[l] == connectionGroupIds[r];
    }
    return res;
  }
}