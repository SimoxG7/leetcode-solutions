import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<Integer> solveQueries(int[] nums, int[] queries) {
    List<Integer> ans = new ArrayList<>();

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.putIfAbsent(nums[i], new ArrayList<>());
      map.get(nums[i]).add(i);
    }

    for (int i = 0; i < queries.length; i++) {
      int target = nums[queries[i]];
      ArrayList<Integer> arr = map.get(target);
      if (arr.size() == 1)
        ans.add(-1);
      else {
        ans.add(minDistance(queries[i], arr, nums.length));
      }

    }

    return ans;
  }

  private int minDistance(int q, List<Integer> arr, int n) {
    int minDist = Integer.MAX_VALUE;
    int pos = Collections.binarySearch(arr, q);

    int left = arr.get((pos - 1 + arr.size()) % arr.size());
    minDist = Math.min(minDist, Math.min(Math.abs(q - left), (n - Math.abs(q - left))));

    int right = arr.get((pos + 1) % arr.size());
    minDist = Math.min(minDist, Math.min(Math.abs(q - right), (n - Math.abs(q - right))));

    return minDist;
  }
}