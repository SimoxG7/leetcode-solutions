import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int maximumSum(int[] nums) {
    Map<Integer, Queue<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int sumDigits = sumDigits(nums[i]);
      Queue<Integer> queue = map.getOrDefault(sumDigits, new PriorityQueue<>(Collections.reverseOrder()));
      queue.add(nums[i]);
      map.put(sumDigits, queue);
    }
    int max = -1;
    for (Queue<Integer> queue : map.values()) {
      if (queue.size() >= 2) max = Math.max(queue.poll() + queue.poll(), max);
    }
    return max;
  }

  // private int digitsCountOfNumber(int num) {
  //   return (int) Math.floor(Math.log10(num) + 1);
  // }

  private int sumDigits(int num) {
    return num == 0 ? 0 : num % 10 + sumDigits(num / 10);
  }
}