class Solution {
  public int maximum69Number(int num) {
    int position = 0, max = num, original = num;
    while (num > 0) {
      if (num % 10 == 6) {
        max = (int) Math.max(original + 3 * Math.pow(10, position), max);
      }
      num /= 10;
      position++;
    }
    return max;
  }
}