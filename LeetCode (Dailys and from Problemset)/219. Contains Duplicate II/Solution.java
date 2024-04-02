import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i])) {
        if (map.get(nums[i]) >= i - k) return true;
      } 
      map.put(nums[i], i);
    }
    return false;
  }
}

// class Solution {
//   public boolean containsNearbyDuplicate(int[] nums, int k) {
//     int n = nums.length;
//     for (int i = 0; i < n; i++) {
//       for (int j = i + 1; j <= i + k && j < n; j++) {
//         if (nums[i] == nums[j]) return true;
//       }
//     }
//     return false;
//   }
// }