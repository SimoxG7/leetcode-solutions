class Solution {
  public int minSwaps(String s) {
    int stack = 0;
    int lowest = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '[') {
        stack++;
      } else {
        stack--;
      }
      lowest = Math.min(lowest, stack);
    }
    return (Math.abs(lowest) + 1) / 2;
  }
}