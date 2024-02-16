import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> dict = new HashMap<>();

    for (int num : arr) {
      dict.put(num, dict.getOrDefault(num, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> sortedDict = new ArrayList<>(dict.entrySet());
    sortedDict.sort(Map.Entry.comparingByValue());

    for (Map.Entry<Integer, Integer> entry : sortedDict) {
      int num = entry.getKey();
      int freq = entry.getValue();

      if (k > 0) {
        if (k >= freq) {
          k -= freq;
          dict.remove(num);
        } else {
          dict.put(num, freq - k);
          k = 0;
        }
      } else {
        break;
      }
    }

    return dict.size();
  }
}