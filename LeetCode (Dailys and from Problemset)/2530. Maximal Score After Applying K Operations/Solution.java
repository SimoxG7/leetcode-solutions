import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public long maxKelements(int[] nums, int k) {
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (var num : nums) {
      queue.add(num);
    }

    long sum = 0;
    while (k-- > 0) {
      int x = queue.poll();
      sum += x;
      queue.add((int) Math.ceil(x / 3.0));
    }
    return sum;
  }
}