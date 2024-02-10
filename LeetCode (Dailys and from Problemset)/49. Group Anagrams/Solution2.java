import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {

      char[] valArr = s.toCharArray();
      Arrays.sort(valArr);
      String key = new String(valArr);

      List<String> ll = map.getOrDefault(key, new ArrayList<String>());
      ll.add(s);
      map.put(key, ll);

    }

    List<List<String>> ans = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      ans.add(entry.getValue());
    }

    return ans;
  }
}