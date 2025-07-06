import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
  int[] nums1;
  int[] nums2;
  Map<Integer, Integer> map = new HashMap<>();

  public FindSumPairs(int[] nums1, int[] nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    for (int n : nums2) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
  }

  public void add(int index, int val) {
    map.put(nums2[index], map.get(nums2[index]) - 1);
    if (map.get(nums2[index]) == 0) {
      map.remove(nums2[index]);
    }

    nums2[index] += val;
    map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
  }

  public int count(int tot) {
    int count = 0;
    for (int n : nums1) {
      count += map.getOrDefault(tot - n, 0);
    }
    return count;
  }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */