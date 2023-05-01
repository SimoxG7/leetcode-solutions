class Solution {
  public int removeDuplicates(int[] nums) {
    int curr = nums[0];
    int currcont = 1;
    int replaceindex = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == curr) {
        if (currcont < 2) {
          currcont++;
          nums[replaceindex++] = curr;
        }
      } else {
        curr = nums[i];
        currcont = 1;
        nums[replaceindex++] = curr;
      }
    }
    return replaceindex;
  }
}