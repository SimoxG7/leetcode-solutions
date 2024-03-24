// class Solution {
//   public int findDuplicate(int[] nums) {
//     int sum = 0;
//     for (int i = 0; i < nums.length; i++) {
//       sum += nums[i];
//     }
//     int incrsum = 0;
//     for (int i = 1; i < nums.length; i++) {
//       incrsum += i;
//     }
//     return sum - incrsum;
//   }
// }

class Solution {
  public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);
      if (nums[index] < 0) return index;
      nums[index] = -nums[index];
    }
    return -1;
  }
}