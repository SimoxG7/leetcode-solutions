class Solution {
  public int maxTotalFruits(int[][] fruits, int startPos, int k) {
    int ans = 0, sum = 0, left = 0;
    for (int right = 0; right < fruits.length; right++) {
      sum += fruits[right][1];
      while (left <= right && steps(fruits[left][0], fruits[right][0], startPos) > k) {
        sum -= fruits[left][1];
        left++;
      }
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public int steps(int left, int right, int start) {
    int diff = right - left;
    int goLeft = Math.abs(start - left) + diff;
    int goRight = Math.abs(start - right) + diff;
    return Math.min(goLeft, goRight);
  }
}