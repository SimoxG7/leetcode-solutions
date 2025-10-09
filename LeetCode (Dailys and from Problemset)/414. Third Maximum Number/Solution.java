//try with booleans, then autoboxing for performance
class Solution {
  public int thirdMax(int[] nums) {
    int first = nums[0], second = 0, third = 0, n = nums.length; //first guaranteed to exist
    boolean foundSecond = false, foundThird = false;
    int i = 1;
    while (i < n && !foundThird) {
      int num = nums[i++];
      if (num == first || (foundSecond && num == second)) continue;
      if (!foundSecond) {
        second = Math.min(num, first);
        first = Math.max(num, first);
        foundSecond = true;
      } else {
        if (num > first) {
          third = second;
          second = first;
          first = num;
        } else if (num > second) {
          third = second;
          second = num;
        } else third = num;
        foundThird = true;
      }
    }

    for (; i < n; i++) {
      int candidate = nums[i];
      if (candidate > third && candidate != first && candidate != second) {
        int[] topThree = topThreeFast(first, second, third, candidate);
        first = topThree[0];
        second = topThree[1];
        third = topThree[2];
      }
    }
    if (foundThird) return third;
    return first;
  }

  private int[] topThreeFast(int a, int b, int c, int d) {
    // Sort ascending first (minimal comparisons)
    if (a > b) {
      int t = a;
      a = b;
      b = t;
    }
    if (c > d) {
      int t = c;
      c = d;
      d = t;
    }
    if (a > c) {
      int t = a;
      a = c;
      c = t;
    }
    if (b > d) {
      int t = b;
      b = d;
      d = t;
    }
    if (b > c) {
      int t = b;
      b = c;
      c = t;
    }

    // Now a ≤ b ≤ c ≤ d
    // Return largest three in descending order
    return new int[] { d, c, b };
  }

}