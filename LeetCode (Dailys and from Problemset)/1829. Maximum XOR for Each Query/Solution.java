class Solution {
  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int[] res = new int[nums.length];
    res[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res[i] = res[i - 1] ^ nums[i];
    }
    int n = (int) (Math.pow(2, maximumBit) - 1);
    for (int i = 0; i < nums.length; i++) {
      res[i] = res[i] ^ n;
    }
    int left = 0;
    int rigth = res.length - 1;
    while (left < rigth) {
      int t = res[left];
      res[left] = res[rigth];
      res[rigth] = t;
      left += 1;
      rigth -= 1;
    }
    return res;
  }
}