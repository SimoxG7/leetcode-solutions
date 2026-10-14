class Solution {
  public String maxSumOfSquares(int num, int sum) {
    if (sum / 9. > num) return "";

    StringBuilder accumulator = new StringBuilder();
    while (sum > 0) {
      int toBeAdded = Math.min(sum, 9);
      accumulator.append(toBeAdded);
      sum -= toBeAdded;
      num--;
    }

    while (num > 0) {
      accumulator.append(0);
      num--;
    }

    return accumulator.toString();
  }
}