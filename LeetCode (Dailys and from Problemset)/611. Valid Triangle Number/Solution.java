import java.util.Arrays;

public class Solution {
  int binarySearch(int nums[], int left, int right, int target) {
    while (right >= left && right < nums.length) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return left;
  }

  public int triangleNumber(int[] nums) {
    int count = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int k = i + 2;
      for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
        k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
        count += k - j - 1;
      }
    }
    return count;
  }
}

// import java.util.Arrays;

// class Solution {
// public int triangleNumber(int[] nums) {
// int n = nums.length;
// if (n <= 2)
// return 0;
// Arrays.sort(nums);
// int count = 0;
// for (int i = 2; i < n; i++) {
// int biggest = nums[i];
// for (int j = i - 1; j >= 1; j--) {
// int right = nums[j];
// for (int k = j - 1; k >= 0; k--) {
// int left = nums[k];
// if (left + right > biggest)
// count++;
// else
// break;
// }
// }
// }
// return count;
// }
// }