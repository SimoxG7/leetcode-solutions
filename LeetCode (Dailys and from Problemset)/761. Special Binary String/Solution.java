import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public String makeLargestSpecial(String s) {
    int n = s.length();
    List<String> list = new ArrayList<>();
    int count = 0, start = 0;

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);

      if (c == '1') count++;
      else count--;

      if (count == 0) {
        String inner = makeLargestSpecial(s.substring(start + 1, i));
        list.add("1" + inner + "0");
        start = i + 1;
      }
    }

    Collections.sort(list, Collections.reverseOrder());
    
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      res.append(list.get(i));
    }
    return res.toString();
  }
}