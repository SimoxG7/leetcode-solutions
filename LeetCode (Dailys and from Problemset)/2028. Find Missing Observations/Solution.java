class Solution {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    final int diceFaces = 6;
    int m = rolls.length;
    final int targetSum = mean * (m + n);
    int rollsSum = 0;
    for (int i = 0; i < m; i++) {
      rollsSum += rolls[i];
    }
    int toConsume = targetSum - rollsSum;
    if (toConsume > n * diceFaces || toConsume < n) return new int[0];
    int[] res = new int[n];
    int resMean = toConsume / n;
    int resMod = toConsume % n;
    int i;
    for (i = 0; i < resMod; i++) {
      res[i] = resMean + 1;
    }
    for (; i < n; i++) {
      res[i] = resMean;
    }
    return res;
  }
}