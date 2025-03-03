class Solution {
  public int[] pivotArray(int[] nums, int pivot) {
    int n = nums.length;
    int res[] = new int[n];
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] < pivot) res[index++] = nums[i];
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] == pivot) res[index++] = nums[i];
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] > pivot) res[index++] = nums[i];
    }
    return res;
  }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//   public int[] pivotArray(int[] nums, int pivot) {
//     int n = nums.length;
//     int res[] = new int[n];
//     List<Integer> lstLess = new ArrayList<>();
//     List<Integer> lstMore = new ArrayList<>();
//     int pivotCounter = 0;
//     for (int i = 0; i < n; i++) {
//       if (nums[i] < pivot) lstLess.add(nums[i]);
//       else if (nums[i] > pivot) lstMore.add(nums[i]);
//       else pivotCounter++;
//     }
//     int index = 0;
//     for (int num : lstLess) {
//       res[index++] = num;
//     }
//     for (int i = 0; i < pivotCounter; i++) {
//       res[index++] = pivot;
//     }
//     for (int num : lstMore) {
//       res[index++] = num;
//     }
//     return res;
//   }
// }