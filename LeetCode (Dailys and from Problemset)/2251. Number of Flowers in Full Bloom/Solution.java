import java.util.Arrays;

class Solution {
  public int[] fullBloomFlowers(int[][] flowers, int[] people) {
    int n = flowers.length;
    int[] start = new int[n];
    int[] end = new int[n];
    for (int i = 0; i < n; i++) {
      start[i] = flowers[i][0];
      end[i] = flowers[i][1] + 1;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int[] ans = new int[people.length];
    int e;
    int s;
    for (int i = 0; i < people.length; i++) {
      e = binarySearch(end, people[i]);
      s = binarySearch(start, people[i]);
      ans[i] = s - e;
    }
    return ans;
  }

  public int binarySearch(int[] A, int target) {
    int l = 0;
    int r = A.length;
    int mid;
    while (l < r) {
      mid = (l + r) / 2;
      if (target < A[mid])
        r = mid;
      else
        l = mid + 1;
    }
    return l;
  }
}