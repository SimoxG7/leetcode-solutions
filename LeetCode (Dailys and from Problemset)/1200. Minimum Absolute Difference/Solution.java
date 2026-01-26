import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> collector = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      int diff = Math.abs(arr[i] - arr[i - 1]);
      if (diff < minDiff) {
        minDiff = diff;
        collector = new ArrayList<>();
      }
      if (diff == minDiff) {
        List<Integer> lst = new ArrayList<>();
        lst.add(arr[i - 1]);
        lst.add(arr[i]);
        collector.add(lst);
      }
    }
    return collector;
  }
}