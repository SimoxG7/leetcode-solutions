import java.util.Arrays;
import java.util.Random;

class Solution {

  private final int[] original;
  private int[] copy;
  private final int n;
  private Random random;

  public Solution(int[] nums) {
    original = nums;
    n = nums.length;
    copy = Arrays.copyOf(nums, n);
    random = new Random();
  }

  public int[] reset() {
    // copy = Arrays.copyOf(original, n);
    return original;
  }

  public int[] shuffle() {
    for (int i = 0; i < n; i++) {
      swap(copy, i, random.nextInt(n));
    }
    return copy;
  }

  //assuming giving indexes are safe of bounds
  private void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */