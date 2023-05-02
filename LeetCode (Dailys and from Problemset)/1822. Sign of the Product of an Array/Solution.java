class Solution {
  public int arraySign(int[] nums) {
    int sign = 1;
    for (int n : nums) {
      if (n == 0) return 0;
      sign *= signFunc(n);
    }
    return sign;
  }

  private int signFunc(int x) {
    if (x > 0) return 1;
    else if (x < 0) return -1;
    else return 0;
  }
}