class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = profit.length;
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) {
      jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
    }
    Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    treeMap.put(0, 0);
    for (int[] job : jobs) {
      int currentProfit = treeMap.floorEntry(job[0]).getValue() + job[2];
      if (currentProfit > treeMap.lastEntry().getValue()) {
        treeMap.put(job[1], currentProfit);
      }
    }
    return treeMap.lastEntry().getValue();
  }
}
