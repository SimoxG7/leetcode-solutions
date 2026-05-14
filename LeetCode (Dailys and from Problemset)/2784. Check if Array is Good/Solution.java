class Solution {
  public boolean isGood(int[] nums) {
    int size = nums.length;
    boolean[] occurrences = new boolean[size];
    boolean lastOccurredTwice = false;
    for (int i = 0; i < size; i++) {
      int num = nums[i];
      if (num >= size) return false;
      if (num == size - 1) {
        if (!occurrences[num]) occurrences[num] = true;
        else if (occurrences[num] && !lastOccurredTwice) lastOccurredTwice = true;
        else return false;
      } else if (occurrences[num]) {
        return false;
      } else {
        occurrences[num] = true;
      }
    }
    return true;
  }
}