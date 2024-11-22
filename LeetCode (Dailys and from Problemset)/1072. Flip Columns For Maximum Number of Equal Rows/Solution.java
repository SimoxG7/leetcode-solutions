import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String, Integer> mp = new HashMap<>();
    int maxi = 0;
    for (int i = 0; i < matrix.length; i++) {
      StringBuilder str = new StringBuilder();
      for (int j = 0; j < matrix[i].length; j++) {
        // flip if starts with one
        if (matrix[i][0] == 1) {
          if (matrix[i][j] == 0)
            str.append(Integer.toString(1));
          else
            str.append(Integer.toString(0));
        } else {
          str.append(Integer.toString(matrix[i][j]));
        }
      }
      mp.put(str.toString(), mp.getOrDefault(str.toString(), 0) + 1);
      maxi = Math.max(maxi, mp.get(str.toString()));
    }
    return maxi;
  }
}