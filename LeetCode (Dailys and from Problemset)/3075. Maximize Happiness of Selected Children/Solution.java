import java.util.Arrays;

class Solution {
  public long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    long dec = 0, sum = 0;
    int index = happiness.length - 1;
    while (k-- > 0) {
      sum += Math.max(0l, happiness[index--] - (dec++));
    }
    return sum;
  }
}