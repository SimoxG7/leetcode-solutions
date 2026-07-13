import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> lst = new ArrayList<>();
    String digits = "123456789";
    int n = String.valueOf(low).length();
    for (int i = n; i <= 9; i++) {
      for (int j = 0; j <= 10 - i - 1; j++) {
        String numStr = digits.substring(j, j + i);
        int num = Integer.parseInt(numStr);
        if (low <= num && num <= high) {
          lst.add(num);
        }
      }
    }
    return lst;
  }
}