class Solution {
  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    double low = 0, high = 1.0;

    while (low < high) {
      double mid = (low + high) / 2;
      int count[] = helper(arr, mid);
      if (k < count[0]) {
        high = mid;
      } else if (k > count[0]) {
        low = mid;
      } else {
        return new int[] { count[1], count[2] };
      }
    }
    return null;
  }

  static int[] helper(int[] arr, double target) {
    int count = 0, i = 0, n = arr.length, num = arr[0], den = arr[n - 1];

    for (int j = 1; j < n; j++) {
      while (arr[i] <= arr[j] * target) {
        i++;
      }
      count += i;
      if (i > 0 && arr[i - 1] * den > arr[j] * num) {
        num = arr[i - 1];
        den = arr[j];
      }
    }
    return new int[] { count, num, den };
  }
}