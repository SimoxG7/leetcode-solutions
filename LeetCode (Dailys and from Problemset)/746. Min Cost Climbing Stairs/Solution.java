class Solution {
  public int minCostClimbingStairs(int[] cost) {

    int single = cost[0];
    int doubl = 0;
    int current;
    for (int i = 1; i < cost.length; i++) {
      current = Math.min(doubl + cost[i], single + cost[i]);
      doubl = single;
      single = current;
    }

    return Math.min(single, doubl);

  }
}