import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> groups = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      if (map.containsKey(groupSizes[i])) {
        List<Integer> lst = map.get(groupSizes[i]);
        lst.add(i);
        map.put(groupSizes[i], lst);
      } else {
        List<Integer> lst = new ArrayList<>();
        lst.add(i);
        map.put(groupSizes[i], lst);
      }
    }
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int size = entry.getKey();
      List<Integer> gen = entry.getValue();
      int length = gen.size();
      int iter = length / size;
      for (int i = 0; i < iter; i++) {
        List<Integer> inner = new ArrayList<>();
        for (int j = 0; j < size; j++) {
          inner.add(gen.get(i*size  + j));
        }
        groups.add(inner);
      }
    }
    return groups;
  }
}