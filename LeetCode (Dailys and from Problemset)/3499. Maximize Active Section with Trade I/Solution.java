import java.util.ArrayList;
import java.util.List;

class Solution {
  public int maxActiveSectionsAfterTrade(String s) {
    List<Integer> list = new ArrayList<>();
    int oneCount = 0;
    int zeroCount = 0;
    
    for (char c : s.toCharArray()) {
      if (c == '0') {
        zeroCount++;
      } else {
        oneCount++;
        if (zeroCount != 0)
          list.add(zeroCount);
        zeroCount = 0;
      }
    }

    if (zeroCount != 0)
      list.add(zeroCount);

    int max = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      max = Math.max(max, list.get(i) + list.get(i + 1));
    }

    return oneCount + max;
  }
}