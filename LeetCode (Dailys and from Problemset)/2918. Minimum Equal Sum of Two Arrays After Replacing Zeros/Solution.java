class Solution {
  public long minSum(int[] nums1, int[] nums2) {
    int zeroes1 = 0, zeroes2 = 0;
    long sum1 = 0, sum2 = 0;
    for (int i = 0; i < nums1.length; i++) {
      if (nums1[i] != 0) sum1 += nums1[i];
      else zeroes1++;
    }
    for (int i = 0; i < nums2.length; i++) {
      if (nums2[i] != 0) sum2 += nums2[i];
      else zeroes2++;
    }
    sum1 += zeroes1;
    sum2 += zeroes2;
    if (sum1 == sum2) {
      return sum1;
    }
    if (sum1 > sum2) {
      if (zeroes2 == 0) return -1;
      else return sum1;
    } else {
      if (zeroes1 == 0) return -1;
      else return sum2;
    }
  }
}