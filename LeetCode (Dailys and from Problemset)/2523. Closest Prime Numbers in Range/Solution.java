import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] closestPrimes(int left, int right) {
    List<Integer> primes = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (isPrime(i)) primes.add(i);
    }
    int[] res = {-1, -1};
    int p = primes.size();
    if (p < 2) return res;
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < p; i++) {
      int diff = primes.get(i) - primes.get(i - 1);
      if (diff < minDiff) {
        minDiff = diff;
        res[0] = primes.get(i - 1);
        res[1] = primes.get(i);
      }
    }
    return res;
  }

  private boolean isPrime(int n) {
    // Corner cases
    if(n <= 1) return false;
    if (n <= 3)
      return true;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n % 2 == 0 || n % 3 == 0)
      return false;

    for (int i = 5; i * i <= n; i = i + 6)
      if (n % i == 0 || n % (i + 2) == 0)
        return false;

    return true;
  }
}