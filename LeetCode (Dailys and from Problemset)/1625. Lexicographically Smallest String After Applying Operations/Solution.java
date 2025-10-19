import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
  public String findLexSmallestString(String s, int a, int b) {
    Queue<String> queue = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    String ans = s;

    queue.offer(s);
    vis.add(s);

    while (!queue.isEmpty()) {
      String curr = queue.poll();
      if (curr.compareTo(ans) < 0)
        ans = curr;

      // Operation 1: Add 'a' to odd indices
      char[] ch = curr.toCharArray();
      for (int i = 1; i < ch.length; i += 2) {
        ch[i] = (char) (((ch[i] - '0' + a) % 10) + '0');
      }
      String addOp = new String(ch);
      if (vis.add(addOp))
        queue.offer(addOp);

      // Operation 2: Rotate right by b positions
      String rotateOp = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
      if (vis.add(rotateOp))
        queue.offer(rotateOp);
    }

    return ans;
  }
}
