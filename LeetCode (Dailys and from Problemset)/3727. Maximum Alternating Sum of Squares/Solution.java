import java.util.Arrays;

class Solution {
  public long maxAlternatingSum(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      nums[i] *= nums[i];
    }

    Arrays.sort(nums);

    int halfLen = n / 2;
    long sum = 0;
    for (int i = 0; i < halfLen; i++) {
      int high = nums[n - i - 1];
      int low = nums[i];
      sum += high - low;
    }
    if (n % 2 == 1)
      sum += nums[halfLen];
    return sum;
  }
}

// import java.util.PriorityQueue;
// import java.util.Queue;

// class Solution {
//   public long maxAlternatingSum(int[] nums) {
//     int n = nums.length;
//     Queue<Integer> queue = new PriorityQueue<>();
//     for (int i = 0; i < n; i++) {
//       queue.add(Math.abs(nums[i]));
//     }

//     long sum = 0;
//     int halfLen = n / 2;
//     for (int i = 0; i < halfLen; i++) {
//       int num = queue.poll();
//       sum += num * num;
//     }
//     sum *= -1;

//     for (int i = halfLen; i < n; i++) {
//       int num = queue.poll();
//       sum += num * num;
//     }
//     return sum;
//   }
// }

// import java.util.Arrays;

// class Solution {
//   public long maxAlternatingSum(int[] nums) {
//     int n = nums.length;
//     for (int i = 0; i < n; i++) {
//       nums[i] = Math.abs(nums[i]);
//     }

//     Arrays.sort(nums);

//     int halfLen = n / 2;
//     long sum = 0;
//     for (int i = 0; i < halfLen; i++) {
//       int high = nums[n - i - 1];
//       int low = nums[i];
//       sum += (high * high) - (low * low);
//     }
//     if (n % 2 == 1)
//       sum += (nums[halfLen] * nums[halfLen]);
//     return sum;
//   }
// }