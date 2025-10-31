class Solution {
  public int[] getSneakyNumbers(int[] nums) {
    boolean[] occurredOnce = new boolean[101];
    int firstDouble = -1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      occurredOnce[num] = !occurredOnce[num];
      if (!occurredOnce[num]) {
        if (firstDouble == -1) firstDouble = num;
        else return new int[] {firstDouble, num};
      }
    }
    return new int[] {}; //unreachable by constraints
  }
}