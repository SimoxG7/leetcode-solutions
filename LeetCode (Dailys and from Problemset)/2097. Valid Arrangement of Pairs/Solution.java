import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
  private Map<Integer, List<Integer>> ad = new HashMap<>();
  private Map<Integer, Integer> in = new HashMap<>();
  private Map<Integer, Integer> out = new HashMap<>();

  public int[][] validArrangement(int[][] pairs) {
    for (int i[] : pairs) {
      ad.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
      out.put(i[0], out.getOrDefault(i[0], 0) + 1);
      in.put(i[1], in.getOrDefault(i[1], 0) + 1);
    }

    int s = findStart(), l = pairs.length, k = 0;
    Stack<Integer> res = new Stack<>();
    findPath(s, res);
    int[][] ans = new int[l][2];

    while (k < l) {
      ans[k][0] = res.pop();
      ans[k++][1] = res.peek();
    }
    return ans;
  }

  public int findStart() {
    int s = 0;
    for (Map.Entry<Integer, Integer> i : out.entrySet()) {
      int a = i.getValue(), b = i.getKey();
      if (a - in.getOrDefault(b, 0) == 1) {
        return b;
      }
      if (b > 0) {
        s = b;
      }
    }
    return s;
  }

  public void findPath(int cur, Stack<Integer> s) {
    while (out.getOrDefault(cur, 0) > 0) {
      out.put(cur, out.get(cur) - 1);
      int nxt = ad.get(cur).get(out.get(cur));
      findPath(nxt, s);
    }
    s.push(cur);
  }
}