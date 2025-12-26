public class Solution {
  public int bestClosingTime(String customers) {
    int bestProfit = 0;
    int bestHour = -1;
    int profit = 0;
    for (int i = 0; i < customers.length(); i++) {
      profit += (customers.charAt(i) == 'Y') ? 1 : -1;
      if (profit > bestProfit) {
        bestProfit = profit;
        bestHour = i;
      }
    }
    return bestHour + 1;
  }
}