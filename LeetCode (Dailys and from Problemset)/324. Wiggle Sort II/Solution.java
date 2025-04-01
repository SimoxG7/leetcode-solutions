import java.util.Arrays;

class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int left = (n - 1) / 2;
    int right = n - 1;
    int res[] = new int[n];
    int i = 0;
    while (left >= 0) {
      res[i++] = nums[left--];
      if (i >= n)
        break;
      res[i++] = nums[right--];
    }
    for (i = 0; i < n; i++)
      nums[i] = res[i];
  }
}