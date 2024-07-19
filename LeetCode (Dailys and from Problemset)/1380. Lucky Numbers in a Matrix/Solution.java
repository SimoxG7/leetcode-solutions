import java.util.ArrayList;
import java.util.List;

class Solution {

  class Pair {
    int val;
    int col;

    Pair(int v, int c) {
      this.val = v;
      this.col = c;
    }
  }

  public List<Integer> luckyNumbers(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    List<Pair> row = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int mini = (int) 1e6;
      int column = -1;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] < mini) {
          mini = matrix[i][j];
          column = j;
        }
      }
      row.add(new Pair(mini, column));
    }

    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < row.size(); i++) {

      int column = row.get(i).col;
      int maxi = -1;
      for (int j = 0; j < m; j++) {
        maxi = Math.max(matrix[j][column], maxi);
      }

      if (maxi == row.get(i).val)
        answer.add(maxi);
    }

    return answer;

  }
}