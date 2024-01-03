import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int n = candies.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, candies[i]);
    }
    List<Boolean> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (candies[i] + extraCandies >= max) res.add(true);
      else res.add(false);
    }
    return res;
  }
}