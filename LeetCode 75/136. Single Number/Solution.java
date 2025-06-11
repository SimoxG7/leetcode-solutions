import java.util.HashSet;
import java.util.Set;

class Solution {
  public int singleNumber(int[] nums) {
    //XOR: if same, will be 0, since all are equal but one, only one will remain!
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i];
    }
    return xor;
  }
}



//works, but not O(1) space
class Solution2 {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        set.remove(nums[i]);
      } else set.add(nums[i]);
    }
    return set.iterator().next();
  }
}

