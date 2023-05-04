import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> ans = new ArrayList<>();
    int num = 0;
    for (int i = 0; i < (1 << n); i++) {
      num ^= i & (-i); //xor bit wise
      ans.add(num);
    }
    return ans;
  }
}