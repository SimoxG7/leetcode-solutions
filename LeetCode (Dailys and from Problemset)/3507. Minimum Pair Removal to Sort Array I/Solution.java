import java.util.ArrayList;
import java.util.List;

class Solution {
  public int minimumPairRemoval(int[] nums) {
    List<Integer> lst = new ArrayList<>();
    for (int num : nums) {
      lst.add(num);
    }

    int operations = 0;

    while (true) {
      boolean isSorted = true;
      for (int i = 0; i < lst.size() - 1; i++) {
        if (lst.get(i) > lst.get(i + 1)) {
          isSorted = false;
          break;
        }
      }

      if (isSorted) {
        return operations;
      }

      int minSum = Integer.MAX_VALUE;
      int index = -1;

      for (int i = 0; i < lst.size() - 1; i++) {
        int sum = lst.get(i) + lst.get(i + 1);
        if (sum < minSum) {
          minSum = sum;
          index = i;
        }
      }

      lst.set(index, minSum);
      lst.remove(index + 1);

      operations++;
    }
  }
}