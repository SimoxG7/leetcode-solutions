class Solution {
  public int numOfSubarrays(int[] arr) {
    int count = 0, sum = 0, even = 1, odd = 0;
    int n = arr.length;
    int mod = 1_000_000_007;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (sum % 2 == 1) {
        count += even;
        odd++;
      } else {
        count += odd;
        even++;
      }
      count %= mod;
    }
    return count;
  }
}