import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] queryResults(int limit, int[][] queries) {
    Map<Integer, Integer> colorMap = new HashMap<>();
    Map<Integer, Integer> ballMap = new HashMap<>();
    int n = queries.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int ball = queries[i][0];
      int color = queries[i][1];

      if (ballMap.containsKey(ball)) {
        int prevColor = ballMap.get(ball);
        int prevColorBalls = colorMap.get(prevColor);
        if (prevColorBalls == 1) colorMap.remove(prevColor);
        else colorMap.put(prevColor, prevColorBalls - 1);
      }

      ballMap.put(ball, color);
      colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

      res[i] = colorMap.keySet().size();
    }
    return res;
  }
}