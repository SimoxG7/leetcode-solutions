import java.util.Arrays;

class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int left = 0, right = people.length-1, res = 0;
    while (left <= right) {
      int sum = people[left] + people[right];
      if (sum <= limit) left++;
      res++;
      right--;
    }
    return res;
  }
}