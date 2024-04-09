class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int n = tickets.length;
    int ticketsAtPosition = tickets[k];
    int time = 0;
    for (int i = 0; i < n; i++) {
      int toBuy;
      if (i > k) toBuy = ticketsAtPosition - 1;
      else toBuy = ticketsAtPosition;
      time += Math.min(tickets[i], toBuy);
    }
    return time;
  }
}