class Solution {
  public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
    long cost = 0;

    if (costBoth <= cost1 + cost2) {
      long amount = Math.min(need1, need2);
      cost += costBoth * amount;
      need1 -= amount;
      need2 -= amount;
    }

    if (need1 <= 0 && need2 <= 0)
      return cost;

    cost1 = Math.min(cost1, costBoth);
    cost2 = Math.min(cost2, costBoth);
    
    cost += cost1 * ((long) need1);
    cost += cost2 * ((long) need2);

    return cost;
  }
}