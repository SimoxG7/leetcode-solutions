import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] findEvenNumbers(int[] digits) {
    int[] digitCounter = new int[10];
    for (int d : digits)
      digitCounter[d]++;
    List<Integer> lst = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      if (digitCounter[i] == 0)
        continue;
      digitCounter[i]--;
      for (int j = 0; j <= 9; j++) {
        if (digitCounter[j] == 0)
          continue;
        digitCounter[j]--;
        for (int k = 0; k <= 8; k += 2) {
          if (digitCounter[k] == 0)
            continue;
          digitCounter[k]--;
          lst.add(i * 100 + j * 10 + k);
          digitCounter[k]++;
        }
        digitCounter[j]++;
      }
      digitCounter[i]++;
    }
    return lst.stream().mapToInt(Integer::intValue).toArray();
  }
}