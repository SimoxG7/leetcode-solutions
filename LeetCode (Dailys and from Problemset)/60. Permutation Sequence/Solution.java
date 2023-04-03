import java.util.ArrayList;
import java.util.List;

class Solution {
  public String getPermutation(int n, int k) {
    int[] fact = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320 };
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }
    return rec(fact, n, k - 1, list, 0) + "";
  }

  private int rec(int[] fact, int n, int k, List<Integer> list, int res) {
    if (n == 0) return res;
    res = res * 10 + list.remove(k / fact[n - 1]);
    return rec(fact, n - 1, k % fact[n - 1], list, res);
  }
}