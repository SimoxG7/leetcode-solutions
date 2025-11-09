class Solution {
  public int countOperations(int num1, int num2) {
    int count = 0;
    int bigger = Math.max(num1, num2);
    int smaller = Math.min(num1, num2);
    while (bigger != 0 && smaller != 0) {
      int newRes = bigger % smaller;
      count += bigger / smaller;
      bigger = Math.max(newRes, smaller);
      smaller = Math.min(newRes, smaller);
    }
    return count;
  }
}