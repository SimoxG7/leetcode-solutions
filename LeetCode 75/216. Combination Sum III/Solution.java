import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    findCombinations(k, n, ans, new ArrayList<>(), 1, 0);
    return ans;
  }

  private void findCombinations(int k, int n, List<List<Integer>> ans, List<Integer> currList, int start, int sum) {
    if (currList.size() == k) {
      if (sum == n)
        ans.add(new ArrayList<>(currList));
      return;
    }
    for (int i = start; i < 10; i++) {
      if (sum + i <= n) {
        currList.add(i);
        findCombinations(k, n, ans, currList, i + 1, sum + i);
        currList.remove(currList.size() - 1);
      } else
        break;
    }
  }
}