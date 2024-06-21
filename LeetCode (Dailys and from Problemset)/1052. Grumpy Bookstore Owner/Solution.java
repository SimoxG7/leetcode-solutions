class Solution {
  private int maxWhenGrumpy(int[] cust, int[] g, int k) {
    int maxi = 0, i = 0, sum = 0, j = 0, n = cust.length;
    while (i < k) {
      if (g[i] == 1)
        sum += cust[i];
      i++;
    }
    maxi = Math.max(maxi, sum);

    while (i < n) {
      if (g[j] == 1)
        sum -= cust[j];
      if (g[i] == 1)
        sum += cust[i];
      maxi = Math.max(maxi, sum);
      i++;
      j++;
    }
    return maxi;

  }

  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int max = 0, n = customers.length;
    max = maxWhenGrumpy(customers, grumpy, minutes);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (grumpy[i] == 0)
        sum += customers[i];
    }
    return max + sum;
  }
}