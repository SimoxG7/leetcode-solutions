import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  class Pair {
    int profit;
    int difficulty;

    Pair(int profit, int difficulty) {
      this.profit = profit;
      this.difficulty = difficulty;
    }

  }

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> b.profit - a.profit);
    priorityQueue.add(new Pair(0, 0));
    for (int i = 0; i < profit.length; i++) {
      priorityQueue.add(new Pair(profit[i], difficulty[i]));
    }
    int res = 0;
    Arrays.sort(worker);
    for (int i = worker.length - 1; i >= 0; i--) {
      while (priorityQueue.peek().difficulty > worker[i]) {
        priorityQueue.poll();
      }
      res += priorityQueue.peek().profit;
    }
    return res;
  }
}