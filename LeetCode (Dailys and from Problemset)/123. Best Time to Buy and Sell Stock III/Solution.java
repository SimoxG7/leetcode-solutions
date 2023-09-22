class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length, pass[] = new int[n], buy = Integer.MAX_VALUE, sell = 0, prof = 0, i;
    // Pass 1: Forward
    for (i = 0; i < n; i++) {
      if (buy > prices[i])
        buy = sell = prices[i];
      sell = Math.max(sell, prices[i]);
      pass[i] = prof = Math.max(prof, sell - buy);
    }

    // Pass 2: Reversed
    int res = pass[n - 1];
    for (i = n - 1, sell = prof = 0, buy = Integer.MAX_VALUE; i > 0; --i) {
      if (sell < prices[i])
        sell = buy = prices[i];
      buy = Math.min(buy, prices[i]);
      res = Math.max(res, pass[i - 1] + sell - buy);
    }
    return res;
  }
}