class Solution {
  public int getMinDistance(int[] nums, int target, int start) {
    if (nums[start] == target) return 0;
    int leftIndex = start - 1, rightIndex = start + 1;
    while (true) {
      if (leftIndex >= 0 && nums[leftIndex] == target) return Math.abs(leftIndex - start);
      if (rightIndex < nums.length && nums[rightIndex] == target) return Math.abs(rightIndex - start);
      leftIndex--;
      rightIndex++;
    }
  }
}

// class Solution {
//   public int getMinDistance(int[] nums, int target, int start) {
//     int min = Integer.MAX_VALUE;
//     for (int i = start; i < nums.length; i++) {
//       if (nums[i] == target) {
//         min = Math.min(min, Math.abs(i - start));
//         break;
//       }
//     }
//     for (int i = start - 1; i >= 0; i--) {
//       if (nums[i] == target) {
//         min = Math.min(min, Math.abs(i - start));
//         break;
//       }
//     }
//     return min;
//   }
// }