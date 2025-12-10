class Solution {
  public int countPermutations(int[] complexity) {
    int n = complexity.length;
    // if there is a lower complexity than root, than it is not unlockable,
    // thus there are 0 permutations possible
    int rootComplexity = complexity[0];
    for (int i = 1; i < n; i++) {
      if (complexity[i] <= rootComplexity) {
        return 0;
      }
    }

    // else it is unlockable and it should (n - 1)!
    long fact = 1;
    int mod = 1_000_000_007;
    for (int i = 2; i < n; i++) {
      fact = (fact * i) % mod;
    }
    return (int) fact;
  }
}