import java.util.ArrayList;
import java.util.List;

class Solution {
  public int numberOfBeams(String[] bank) {
    List<Integer> acc = new ArrayList<>();
    for (int i = 0; i < bank.length; i++) {
      String curr = bank[i];
      int cont = 0;
      for (int j = 0; j < curr.length(); j++) {
        if (curr.charAt(j) == '1') cont++; 
      }
      if (cont > 0) acc.add(cont);
    }
    int res = 0;
    for (int i = 1; i < acc.size(); i++) {
      res += acc.get(i-1) * acc.get(i);
    }
    return res;
  }
}