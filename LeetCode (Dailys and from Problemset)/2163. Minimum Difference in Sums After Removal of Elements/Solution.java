import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public long minimumDifference(int[] nums) {
    int n3 = nums.length, n = n3 / 3;
    long[] part1 = new long[n + 1];
    long sum = 0;
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      pq.add(nums[i]);
    }
    part1[0] = sum;
    for (int i = n; i < n * 2; i++) {
      sum += nums[i];
      pq.add(nums[i]);
      sum -= pq.poll();
      part1[i - (n - 1)] = sum;
    }
    long part2 = 0;
    Queue<Integer> pq1 = new PriorityQueue<>();
    for (int i = n * 3 - 1; i >= n * 2; i--) {
      part2 += nums[i];
      pq1.add(nums[i]);
    }
    long ans = part1[n] - part2;
    for (int i = n * 2 - 1; i >= n; i--) {
      part2 += nums[i];
      pq1.add(nums[i]);
      part2 -= pq1.poll();
      ans = Math.min(ans, part1[i - n] - part2);
    }
    return ans;
  }
}