class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Size = nums1.length;
    int nums2Size = nums2.length;
    int n = nums1Size + nums2Size;
    double res;
    double[] nums3 = new double[n];
    int i, j, k, a;
    i = j = k = 0;
    while (i < nums1Size && j < nums2Size) {
      if (nums1[i] < nums2[j])
        nums3[k++] = nums1[i++];
      else
      nums3[k++] = nums2[j++];
    }
    for (; i < nums1Size; i++)
      nums3[k++] = nums1[i];
    for (; j < nums2Size; j++)
      nums3[k++] = nums2[j];
    if (n % 2 == 0) {
      a = n / 2;
      res = (nums3[a] + nums3[a - 1]) / 2;
      return res;
    } else {
      res = nums3[n / 2];
      return res;
    }
  }
}
