import java.util.List;

class Solution {
  public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    int strictlyIncreasingCount = 1, n = nums.size(), secondStrictlyIncreasingCount = -1, startIndex = 0;
    if (k == 1 && n >= 2) return true;
    for (int i = 0; i < n - 1; i++) {
      if (nums.get(i) < nums.get(i + 1)) {
        if (strictlyIncreasingCount == k) {
          secondStrictlyIncreasingCount++;
        } else {
          strictlyIncreasingCount++;
          if (strictlyIncreasingCount == k) {
            secondStrictlyIncreasingCount = 1;
            i++;
          }
        }
      } else {
        i = startIndex++;
        strictlyIncreasingCount = 1;
        secondStrictlyIncreasingCount = -1;
      }
      if (strictlyIncreasingCount == k && secondStrictlyIncreasingCount == k) return true;
    }
    return strictlyIncreasingCount == k && secondStrictlyIncreasingCount == k;
  }
}

// k = 3
// 1,2,3,7,4,5,6,7,8,2,6,3,2,1,2,3,4,5,6,7,8
// 1,2,3 is ok, counting from index = 3 (7) -> wrong at index = 4 (4). start from index = 4 again
// 4,5,6 is ok, counting from index = 7 (7) -> wrong at index = 9 (2). start from index = 9 again
// 2,6,3 is not ok, start from index 11 (3) again
// 3,2 is not ok, start from index 12 (2) again
// 2,1 is not ok, start from index 13 (1) again
// 1,2,3 is ok, counting from index = 16 (4) -> 4,5,6 is ok -> return true