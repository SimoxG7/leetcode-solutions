import java.util.Arrays;
import java.util.TreeMap;

class Solution {
  public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(tasks);
    Arrays.sort(workers);

    int left = 0;
    int right = Math.min(tasks.length, workers.length);

    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (canAssign(tasks, workers, pills, strength, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int count) {
    TreeMap<Integer, Integer> available = new TreeMap<>();

    for (int i = workers.length - count; i < workers.length; i++) {
      available.put(workers[i], available.getOrDefault(workers[i], 0) + 1);
    }

    for (int i = count - 1; i >= 0; i--) {
      int task = tasks[i];

      Integer worker = available.ceilingKey(task);
      if (worker != null) {
        decrementCount(available, worker);
      } else {
        if (pills == 0)
          return false;
        worker = available.ceilingKey(task - strength);
        if (worker == null)
          return false;

        decrementCount(available, worker);
        pills--;
      }
    }

    return true;
  }

  private void decrementCount(TreeMap<Integer, Integer> map, int key) {
    int count = map.get(key);
    if (count == 1) {
      map.remove(key);
    } else {
      map.put(key, count - 1);
    }
  }
}