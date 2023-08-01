import java.util.ArrayList;
import java.util.List;

class Solution2 {
  
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    bt(0, res, l, k, arr);
    return res;
  }

  void bt(int i, List<List<Integer>> res, List<Integer> l, int k, int arr[]) {
    if (i == arr.length) {
      if (l.size() == k) {
        res.add(new ArrayList<>(l));
      }
      return;
    }
    l.add(arr[i]);
    bt(i + 1, res, l, k, arr);
    l.remove(l.size() - 1);
    bt(i + 1, res, l, k, arr);
  }
}