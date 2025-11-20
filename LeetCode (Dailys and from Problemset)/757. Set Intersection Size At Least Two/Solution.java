class Solution {
  public int intersectionSizeTwo(int[][] intervals) {
    java.util.Arrays.sort(intervals, (a, b) -> {
      if (a[1] != b[1])
        return a[1] - b[1];
      return b[0] - a[0];
    });

    int count = 0;
    int a = -1, b = -1;

    for (int[] in : intervals) {
      int start = in[0], end = in[1];

      boolean aIn = (a >= start && a <= end);
      boolean bIn = (b >= start && b <= end);

      if (aIn && bIn) {
        continue;
      }

      if (aIn) {
        b = a;
        a = end;
        count++;
      } else {
        b = end - 1;
        a = end;
        count += 2;
      }
    }

    return count;
  }
}