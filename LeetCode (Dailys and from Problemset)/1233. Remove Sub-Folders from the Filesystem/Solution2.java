import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<String> removeSubfolders(String[] folder) {
    Arrays.sort(folder);
    List<String> res = new ArrayList<>();
    res.add(folder[0]);
    for (int i = 1; i < folder.length; i++) {
      String st = folder[i];
      if (!st.startsWith(res.get(res.size() - 1) + "/")) {
        res.add(st);
      }
    }
    return res;
  }
}