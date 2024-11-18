class Solution {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int[] res = new int[n];
    if (k == 0)
      return res;
    int left = 1;
    int right = k;
    int sum = 0;
    if (k < 0) {
      left = n - Math.abs(k);
      right = n - 1;
    }
    for (int i = left; i <= right; i++) {
      sum += code[i % n];
    }
    for (int i = 0; i < n; i++) {
      res[i] = sum;
      sum -= code[left % n];
      sum += code[(right + 1) % n];
      left++;
      right++;
    }
    return res;
  }
}