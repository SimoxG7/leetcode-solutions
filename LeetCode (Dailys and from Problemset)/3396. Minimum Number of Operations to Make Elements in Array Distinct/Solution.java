class Solution {
  public int minimumOperations(int[] nums) {
    int[] freq = new int[101];

    for (int i = nums.length - 1; i >= 0; i--) {
      if (++freq[nums[i]] > 1)
        return (int) Math.ceil((double) (i + 1) / 3);
    }
    return 0;
  }
}

// class Solution {
// public int minimumOperations(int[] nums) {
// int[] occurrMap = new int[101];
// int nonDistinctNumberCounter = 0;
// int n = nums.length;
// int operations = 0;
// for (int i = 0; i < n; i++) {
// occurrMap[nums[i]]++;
// if (occurrMap[nums[i]] == 2) nonDistinctNumberCounter++;
// }
// int index = 0;
// while (nonDistinctNumberCounter > 0) {
// int limit = index + 3;
// while (index < n && index < limit) {
// if (occurrMap[nums[index]] == 2) {
// nonDistinctNumberCounter--;
// }
// occurrMap[nums[index]]--;
// index++;
// }
// operations++;
// }
// return operations;
// }
// }