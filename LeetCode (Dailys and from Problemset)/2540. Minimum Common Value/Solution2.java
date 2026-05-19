class Solution {
  public int getCommon(int[] nums1, int[] nums2) {
    int index1 = 0, index2 = 0;
    while (index1 < nums1.length && index2 < nums2.length) {
      int num1 = nums1[index1], num2 = nums2[index2];
      if (num1 == num2) return num1;
      else if (num1 < num2) index1++;
      else index2++;
    }
    if (index1 == nums1.length) {
      while (index2 < nums2.length) {
        if (nums1[index1-1] == nums2[index2]) return nums1[index1-1];
        else index2++;
      }
    } else if (index2 == nums2.length) {
      while (index1 < nums1.length) {
        if (nums2[index2-1] == nums1[index1]) return nums2[index2-1];
        else index1++;
      }
    }
    return -1;
  }
}