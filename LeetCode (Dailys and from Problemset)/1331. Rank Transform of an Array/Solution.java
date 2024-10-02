import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int n = arr.length;
    int[] copy = Arrays.copyOf(arr, n);
    Arrays.sort(copy);
    Map<Integer, Integer> map = new HashMap<>();
    int index = 1;
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(copy[i])) {
        map.put(copy[i], index++);
      }
    }
    for (int i = 0; i < n; i++) {
      arr[i] = map.get(arr[i]);
    }
    return arr;
  }
}