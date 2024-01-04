// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// class Solution {
//   public List<String> findRepeatedDnaSequences(String s) {
//     List<String> res = new ArrayList<>();
//     if (s.length() < 10) return res;
//     Map<String, Integer> map = new HashMap<>();
//     int subLen = 10;
//     for (int i = 0; i <= s.length() - subLen; i++) {
//       String subString = s.substring(i, i + subLen);
//       map.put(subString, map.getOrDefault(subString, 0) + 1);
//     }
//     Set<Map.Entry<String, Integer>> set = map.entrySet();
//     for (Map.Entry<String, Integer> entry : set) {
//       if (entry.getValue() > 1) res.add(entry.getKey());
//     }
//     return res;
//   }
// }

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seenOnce = new HashSet<>();
    Set<String> seenTwice = new HashSet<>();
    int subLen = 10;
    for (int i = 0; i <= s.length() - subLen; i++) {
      String sub = s.substring(i, i + subLen);
      if (!seenOnce.add(sub)) {
        seenTwice.add(sub);
      }
    }
    return new ArrayList<>(seenTwice);
  }
}


