import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> buildArray(int[] target, int n) {
    List<String> res = new ArrayList<>();
    int index = 0;
    for (int i = 1; i <= n; i++) {
      if (target[index] == i) {
        res.add("Push");
        index++;
        if (index == target.length) return res;
      } else {
        res.add("Push");
        res.add("Pop");
      }
    }
    return res;
  }
}