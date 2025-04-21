class Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int curr = 0;
    int min = 0;
    int max = 0;

    for (int d : differences) {
      curr += d;
      min = Math.min(min, curr);
      max = Math.max(max, curr);

      if ((upper - max) - (lower - min) + 1 <= 0) {
        return 0;
      }
    }

    return (upper - max) - (lower - min) + 1;
  }
}