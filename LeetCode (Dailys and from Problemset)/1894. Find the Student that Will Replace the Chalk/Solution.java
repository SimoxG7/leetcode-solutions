class Solution {
  public int chalkReplacer(int[] chalk, int k) {
    long chalkSum = 0;
    int n = chalk.length;
    for (int i = 0; i < n; i++) {
      chalkSum += chalk[i];
    }
    k = (int) ((long) k %  chalkSum);
    for (int i = 0; i < n; i++) {
      if (k - chalk[i] < 0) return i;
      k -= chalk[i];
    }
    return 0;
  }
}