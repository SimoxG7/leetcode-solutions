import java.util.ArrayList;
import java.util.List;

class Solution {
  public boolean checkPowersOfThree(int n) {
    List<Integer> lst = new ArrayList<>();
    int num = 1;
    lst.add(num);
    while (num < n) {
      num *= 3;
      lst.add(num);
    }
    int i = lst.size() - 1;
    while (n > 0 && i >= 0) {
      int pwr = lst.get(i--);
      if (n >= pwr) n -= pwr;
    }
    return n == 0;
  }
}