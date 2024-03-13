class Solution {
  public int pivotInteger(int n) {
    if (n == 1) return 1;
    if (n == 2) return -1;
    int left = 0, right = 0, pivot = n;
    for (int i = 1; i < n; i++) {
      left += i;
    }
    while (left > right) {
      right += pivot--;
      left -= pivot;
    }
    if (left == right) return pivot;
    return -1;
  }
}