import java.util.Arrays;

class Solution {
  public int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n];
    int range = 2 * k + 1;
    if (k != 0 && range > n) {
      Arrays.fill(res, 0, res.length, -1);
      return res;
    }
    long[] op = new long[n - (2 * k)];
    for (int i = 0; i < range; i++) {
      op[0] += nums[i];
    }
    for (int i = 1; i < n - (2 * k); i++) {
      op[i] = op[i - 1] + nums[i + 2*k] - nums[i - 1];
    }
    for (int i = 0; i < k; i++) {
      res[i] = -1;
      res[n - i - 1] = -1;
    }
    for (int i = k; i < n - k; i++) {
      res[i] = (int) (op[i - k] / range);
    }
    return res;
  }
}

// import java.util.Arrays;

// class Solution {
//   public int[] getAverages(int[] nums, int k) {
//     int n = nums.length;
//     int[] res = new int[n];
//     int range = 2 * k + 1;
//     if (k != 0 && range > n) {
//       Arrays.fill(res, 0, res.length, -1);
//       return res;
//     } 
//     long[] op = new long[n];
//     for (int i = 0; i < range; i++) {
//       op[k] += nums[i];
//     }
//     for (int i = k + 1; i < n - k; i++) {
//       op[i] = op[i - 1] + nums[i + k] - nums[i - k - 1];
//     }
//     for (int i = 0; i < k; i++) {
//       res[i] = -1;
//       res[n - i - 1] = -1;
//     }
//     for (int i = k; i < n - k; i++) {
//       res[i] = (int) (op[i]/range);
//     }
//     return res;
//   }
// }
