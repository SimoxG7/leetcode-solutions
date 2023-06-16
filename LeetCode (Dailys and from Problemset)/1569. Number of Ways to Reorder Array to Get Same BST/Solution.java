class Solution {
  private static final long MOD = 1_000_000_007L;
  private static final int MAX_N_COUNT = 1001;
  private static int[][] pascalsTriangle = new int[MAX_N_COUNT][];

  public int numOfWays(int[] nums) {
    int n = nums.length;

    // Build table of Pascal's triangle values, if not already built.
    // Only have to build it once per SUBMIT, then all test cases
    // can use the same triangle.
    if (pascalsTriangle[0] == null) {
      for (int i = 0; i < MAX_N_COUNT; i++) {
        pascalsTriangle[i] = new int[i + 1];
        pascalsTriangle[i][0] = pascalsTriangle[i][i] = 1;
        for (int j = 1; j < i; j++)
          pascalsTriangle[i][j] = (int) (((long) pascalsTriangle[i - 1][j - 1] +
              (long) pascalsTriangle[i - 1][j]) % MOD);
      }
    }

    // Recursively pass an array representing a root followed by
    // the values below that root.
    return (int) ((dfs(nums, n) - 1) % MOD);
  }

  private long dfs(int[] nums, int n) {
    if (n <= 2)
      return 1;
    final int[] left = new int[n - 1];
    final int[] right = new int[n - 1];
    final int rootVal = nums[0];
    int leftIdx = 0;
    int rightIdx = 0;
    for (int i = 1; i < n; i++)
      if (nums[i] < rootVal)
        left[leftIdx++] = nums[i];
      else
        right[rightIdx++] = nums[i];
    return (((dfs(left, leftIdx) * dfs(right, rightIdx)) % MOD) *
        pascalsTriangle[n - 1][leftIdx]) % MOD;
  }
}