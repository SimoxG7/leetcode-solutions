class Solution {
  public long getDescentPeriods(int[] prices) {
    long count = 0;
    int currSequence = 1;
    int prev = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] == prev - 1) currSequence++;
      else {
        count += gaussSeries(currSequence);
        currSequence = 1;
      }
      prev = prices[i];
    }
    return count + gaussSeries(currSequence);
  }

  private long gaussSeries(long n) {
    return (n * (n + 1)) >> 1;
  }
}