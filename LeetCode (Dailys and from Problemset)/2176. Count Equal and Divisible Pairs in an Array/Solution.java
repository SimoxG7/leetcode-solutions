class Solution {
  public int countPairs(int[] nums, int k) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] == nums[j] && (i * j) % k == 0) count++;
      }
    }
    return count;
  }
}


// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Solution {
//   public int countPairs(int[] nums, int k) {
//     int n = nums.length;
//     int count = 0;
//     Map<Integer, List<Integer>> map = new HashMap<>();
//     for (int i = 0; i < n; i++) {
//       List<Integer> lst = map.getOrDefault(nums[i], new ArrayList<>());
//       lst.add(i);
//       map.put(nums[i], lst);
//     }
//     for (List<Integer> lst : map.values()) {
//       int l = lst.size();
//       for (int i = 0; i < l - 1; i++) {
//         for (int j = i + 1; j < l; j++) {
//           if ((lst.get(i) * lst.get(j)) % k == 0) count++;
//         }
//       }
//     }
//     return count;
//   }
// }