import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  // public int findKthLargest(int[] nums, int k) {
  // Arrays.sort(nums);
  // return nums[nums.length - k];
  // }
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }

    return minHeap.peek();
  }
}