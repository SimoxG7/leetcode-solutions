import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int minOperations(int[] nums, int k) {
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      queue.add(nums[i]);
    }

    int count = 0;
    while (queue.peek() < k && queue.size() >= 2) {
      int res = queue.poll() * 2 + queue.poll();
      if (res < 0) res = k;
      queue.add(res);
      count++;
    }

    return count;
  }
}