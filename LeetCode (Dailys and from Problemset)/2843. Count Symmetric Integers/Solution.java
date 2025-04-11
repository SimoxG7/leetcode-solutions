class Solution {
  public int countSymmetricIntegers(int low, int high) {
    int ans = 0;
    for (int i = low; i <= high; i++) {
      int num = i;
      if (num > 10 && num <= 99) {
        if (num % 11 == 0)
          ans++;
      } else if (num > 1000 && num <= 9999) {
        int first = num % 10;
        num /= 10;
        first += num % 10;
        num /= 10;
        int second = num % 10;
        num /= 10;
        second += num % 10;
        if (first == second) {
          ans++;
        }
      }
    }
    return ans;
  }
}