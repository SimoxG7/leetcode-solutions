import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    for (int i : stones) pq.add(i);
    
    while (pq.size() > 1) pq.add(pq.poll() - pq.poll());
    
    return pq.poll();
  }
}