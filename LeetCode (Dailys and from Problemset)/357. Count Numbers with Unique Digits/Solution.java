class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    else if (n == 1) return 10;
    int num = 9, possibilities = 9, iter = n;
    while (iter > 1) {
      num *= possibilities--;
      iter--;
    }
    return num + countNumbersWithUniqueDigits(n - 1);
  }
}