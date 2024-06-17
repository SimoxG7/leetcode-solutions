class Solution {
  public boolean judgeSquareSum(int c) {
    long left = 0;
    long right = (long) Math.sqrt(c);
    while (left <= right) {
      long leftsq = left * left, rightsq = right * right;
      long sum = leftsq + rightsq;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }
}