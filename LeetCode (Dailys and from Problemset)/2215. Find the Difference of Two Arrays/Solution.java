import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Map<Integer, Integer> occurr1 = new HashMap<>();
    Map<Integer, Integer> occurr2 = new HashMap<>();
    for (int i : nums1) {
      occurr1.put(i, occurr1.getOrDefault(i, 0) + 1);
    }
    for (int i : nums2) {
      occurr2.put(i, occurr2.getOrDefault(i, 0) + 1);
    }
    List<Integer> answer1 = new ArrayList<>();
    List<Integer> answer2 = new ArrayList<>(); 
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set1 = occurr1.keySet();
    Set<Integer> set2 = occurr2.keySet();
    for (int n : set1) {
      if (!set2.contains(n)) answer1.add(n);
    }
    for (int n : set2) {
      if (!set1.contains(n)) answer2.add(n);
    }
    res.add(answer1);
    res.add(answer2);
    return res;
  }
}