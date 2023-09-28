// import java.util.ArrayList;
// import java.util.List;

public class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int i = 0, j = nums.length - 1;

    while (i < j) {
      while (i < j && nums[i] % 2 == 0)
        i++;
      while (i < j && nums[j] % 2 == 1)
        j--;

      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    return nums;
  }
}

// class Solution {
// public int[] sortArrayByParity(int[] nums) {
// List<Integer> even = new ArrayList<>();
// List<Integer> odd = new ArrayList<>();
// for (int i = 0; i < nums.length; i++) {
// if (nums[i] % 2 == 0) {
// even.add(nums[i]);
// } else {
// odd.add(nums[i]);
// }
// }
// int index = 0;
// for (int i : even) {
// nums[index++] = i;
// }
// for (int i : odd) {
// nums[index++] = i;
// }
// return nums;
// }
// }