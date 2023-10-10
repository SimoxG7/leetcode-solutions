import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int compareVersion(String version1, String version2) {
    List<Integer> v1 = new ArrayList<>(); //either one is fine
    List<Integer> v2 = new LinkedList<>();
    String[] v1split = version1.split("\\.");
    String[] v2split = version2.split("\\.");
    for (String s : v1split) {
      v1.add(Integer.parseInt(s));
    }
    for (String s : v2split) {
      v2.add(Integer.parseInt(s));
    }
    if (v1.size() != v2.size()) {
      int diff = Math.abs(v1.size() - v2.size());
      if (v1.size() > v2.size()) {
        for (int i = 0; i < diff; i++) {
          v2.add(0);
        }
      } else {
        for (int i = 0; i < diff; i++) {
          v1.add(0);
        }
      }
    }
    for (int i = 0; i < v1.size(); i++) {
      if (Integer.compare(v1.get(i), v2.get(i)) != 0) {
        if (v1.get(i) < v2.get(i)) return -1;
        else return 1;
      }
    }
    return 0;
  }
}