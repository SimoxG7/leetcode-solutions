class Solution {
  public void sortColors(int[] nums) {
    int[] colors = new int[3];
    for (int n : nums) {
      colors[n]++;
    }
    int index = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < colors[i]; j++) {
        nums[index++] = i;
      }
    }
  }
}