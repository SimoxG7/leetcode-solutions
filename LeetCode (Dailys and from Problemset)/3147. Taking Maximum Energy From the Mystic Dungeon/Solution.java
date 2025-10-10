class Solution {
  public int maximumEnergy(int[] energy, int k) {
    int n = energy.length;
    int ans = Integer.MIN_VALUE;
    for (int i = n - 1; i >= n - k; i--) {
      int sum = 0;
      for (int j = i; j >= 0; j -= k) {
        sum += energy[j];
        ans = Math.max(ans, sum);
      }
    }
    return ans;
  }
}