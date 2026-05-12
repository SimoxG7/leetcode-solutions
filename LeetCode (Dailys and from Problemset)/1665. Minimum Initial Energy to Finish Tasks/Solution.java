import java.util.Arrays;

class Solution {
  public int minimumEffort(int[][] tasks) {

    // sort by (minimum - actual) descending
    Arrays.sort(tasks, (a, b) -> {
      return (b[1] - b[0]) - (a[1] - a[0]);
    });

    int res = 0;
    int curr = 0;

    for (int[] task : tasks) {

      int actual = task[0];
      int minimum = task[1];

      if (curr < minimum) {
        res += (minimum - curr);
        curr = minimum;
      }

      curr -= actual;
    }

    return res;
  }
}