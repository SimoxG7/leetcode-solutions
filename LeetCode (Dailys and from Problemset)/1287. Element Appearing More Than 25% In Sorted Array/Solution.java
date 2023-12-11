import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int findSpecialInteger(int[] arr) {
    if (arr.length < 2) {
      return arr[0];
    }
    int result = 0;
    int percent = (int) (arr.length * 0.25);
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (int key : map.keySet()) {
      if (map.get(key) > percent) {
        result = key;
      }
    }

    return result;
  }
}