import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    List<int[]> lst = new ArrayList<>();
    int nums1Index = 0, nums2Index = 0;
    int nums1Len = nums1.length, nums2Len = nums2.length;
    while (nums1Index < nums1Len && nums2Index < nums2Len) {
      int nums1Id = nums1[nums1Index][0], nums2Id = nums2[nums2Index][0];
      if (nums1Id == nums2Id) {
        int[] subArray = {nums1Id, nums1[nums1Index][1] + nums2[nums2Index][1]};
        lst.add(subArray);
        nums1Index++;
        nums2Index++;
      } else if (nums1Id < nums2Id) {
        int[] subArray = {nums1Id, nums1[nums1Index][1]};
        lst.add(subArray);
        nums1Index++;
      } else {
        int[] subArray = {nums2Id, nums2[nums2Index][1]};
        lst.add(subArray);
        nums2Index++;
      }
    }
    while (nums1Index < nums1Len) {
      int[] subArray = {nums1[nums1Index][0], nums1[nums1Index][1]};
      lst.add(subArray);
      nums1Index++;
    }
    while (nums2Index < nums2Len) {
      int[] subArray = {nums2[nums2Index][0], nums2[nums2Index][1]};
      lst.add(subArray);
      nums2Index++;
    }
    return lst.toArray(int[][]::new);
  }
}

// import java.util.Map;
// import java.util.TreeMap;

// class Solution {
//   public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
//     Map<Integer, Integer> map = new TreeMap<>();
//     for (int i = 0; i < nums1.length; i++) {
//       map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
//     }
//     for (int i = 0; i < nums2.length; i++) {
//       map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
//     }
//     System.out.println(map);
//     int[][] res = new int[map.size()][2];
//     int i = 0;
//     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//       res[i][0] = entry.getKey();
//       res[i][1] = entry.getValue();
//       i++;
//     }
//     return res;
//   }
// }