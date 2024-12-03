import java.util.ArrayList;
import java.util.List;

class Solution {
  public String addSpaces(String s, int[] spaces) {
    List<String> l = new ArrayList<>();
    int prev = 0;
    for (int i : spaces) {
      l.add(s.substring(prev, i));
      prev = i;
    }
    l.add(s.substring(prev));
    StringBuilder sb = new StringBuilder();
    for (String st : l) {
      if (st == l.get(l.size() - 1))
        continue;
      sb.append(st + " ");
    }
    sb.append(l.get(l.size() - 1));
    return sb.toString();
  }
}