class Solution {
  public int numWaterBottles(int n, int target) {
    int sum = n;
    while (n / target != 0) {
      sum += n / target;
      n = n / target + n % target;
    }
    return sum;
  }
}