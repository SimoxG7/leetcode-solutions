class Solution {
  public double averageWaitingTime(int[][] customers) {
    double chefTime = 0;
    double totWaitingTime = 0;
    int totCustomers = customers.length;
    for (int i = 0; i < totCustomers; i++) {
      int arrivalTime = customers[i][0];
      int cookingTime = customers[i][1];
      if (chefTime > arrivalTime) {
        totWaitingTime += chefTime - arrivalTime;
        chefTime += cookingTime;
      } else {
        chefTime += cookingTime + (arrivalTime - chefTime);
      }
      totWaitingTime += cookingTime;
    }
    return totWaitingTime / totCustomers;
  }
}