import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> res = new ArrayList<>();
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      set1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      set2.add(nums2[i]);
    }
    for (Integer i : set1) {
      if (set2.contains(i)) res.add(i);
    }
    return res.stream().mapToInt(i -> i).toArray();
  }
}

// class Solution {
//   public int[] intersection(int[] nums1, int[] nums2) {
//     List<Integer> res = new ArrayList<>();
//     Arrays.sort(nums1);
//     Arrays.sort(nums2);
//     int index1 = 0, index2 = 0;
//     int lastAdded = -1;
//     while (index1 != nums1.length && index2 != nums2.length) {
//       int num1 = nums1[index1], num2 = nums2[index2];
//       if (num1 == num2) {
//         if (num1 != lastAdded) {
//           res.add(num1);
//           lastAdded = num1;
//         }
//         index1++;
//         index2++;
//       } else if (num1 < num2) {
//         index1++;
//       } else {
//         index2++;
//       }
//     }
//     while (index1 < nums1.length) {
//       if (nums1[index1] == nums2[index2-1]) {
//         if (nums1[index1] != lastAdded) {
//           res.add(nums1[index1]);
//           lastAdded = nums1[index1];
//         }
//       }
//       index1++;
//     }
//     while (index2 < nums2.length) {
//       if (nums2[index2] == nums1[index1-1]) {
//         if (nums2[index2] != lastAdded) {
//           res.add(nums2[index2]);
//           lastAdded = nums2[index2];
//         }
//       }
//       index2++;
//     }
//     return res.stream().mapToInt(i -> i).toArray();
//   }
// }