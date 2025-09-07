class Solution {
  public int[] sumZero(int n) {
    int bound = n / 2;
    boolean isEven = n % 2 == 0;
    int[] res = new int[n];
    int idx = 0;
    for (int i = bound * (- 1); i < 0; i++) {
      res[idx++] = i;
    }
    if (!isEven) res[idx++] = 0;
    for (int i = 1; i <= bound; i++) {
      res[idx++] = i;
    }
    return res;
  }
}