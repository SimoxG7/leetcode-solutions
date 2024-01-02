// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// class Solution {
//   public List<List<Integer>> findMatrix(int[] nums) {
//     Map<Integer, Integer> map = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) {
//       int num = nums[i];
//       map.put(num, map.getOrDefault(num, 0) + 1);
//     };
//     List<List<Integer>> lst = new ArrayList<>();
//     while (map.size() > 0) {
//       List<Integer> sublist = new ArrayList<>();
//       Set<Map.Entry<Integer, Integer>> set = new HashSet<>(map.entrySet());
//       for (Map.Entry<Integer, Integer> entry : set) {
//         if (entry.getValue() == 1) {
//           map.remove(entry.getKey());
//         } else {
//           map.put(entry.getKey(), entry.getValue() - 1);
//         }
//         sublist.add(entry.getKey());
//       }
//       lst.add(sublist);
//     }
//     return lst;
//   }
// }

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> findMatrix(int[] nums) {
    int[] freq = new int[nums.length + 1];
    List<List<Integer>> ans = new ArrayList<>();
    for (int n : nums) {
      if (freq[n] >= ans.size()) {
        ans.add(new ArrayList<>());
      }
      ans.get(freq[n]).add(n);
      freq[n]++;
    }
    return ans;
  }
}
