class Solution {
  public int totalWaviness(int num1, int num2) {
    int count = 0;
    for (int i = num1; i <= num2; i++) {
      int num = i;
      int a = num % 10;
      num = num / 10;
      int b = num % 10;
      num = num / 10;
      while (num > 0) {
        int c = num % 10;
        num = num / 10;
        if ((b > c && b > a) || (b < c && b < a))
          count++;
        a = b;
        b = c;
      }
    }
    return count;
  }
}