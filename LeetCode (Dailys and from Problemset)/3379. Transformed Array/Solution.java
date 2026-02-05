class Solution {
  public int[] constructTransformedArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = nums[((i + nums[i]) % n + n) % n];
    }
    return result;
  }
}

// class Solution {
//   public int[] constructTransformedArray(int[] nums) {
//     int n = nums.length;
//     int[] result = new int[n];
//     for (int i = 0; i < n; i++) {
//       int num = nums[i];
//       if (num > 0) {
//         result[i] = nums[(i + num) % n];
//       } else if (num < 0) {
//         int val = (i + num) % n;
//         if (val < 0) val += n;
//         result[i] = nums[val];
//       } else {
//         result[i] = num;
//       }
//     }
//     return result;
//   }
// }
