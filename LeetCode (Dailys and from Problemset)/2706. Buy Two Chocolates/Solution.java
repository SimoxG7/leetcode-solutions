class Solution {
  public int buyChoco(int[] prices, int money) {
    int min1 = Math.min(prices[0], prices[1]);
    int min2 = Math.max(prices[0], prices[1]);
    for (int i = 2; i < prices.length; i++) {
      if (prices[i] < min1) {
        min2 = min1;
        min1 = prices[i];
      } else if (prices[i] < min2) {
        min2 = prices[i];
      }
    }
    int res = money - (min1 + min2);
    if (res >= 0) return res;
    return money;
  }
}