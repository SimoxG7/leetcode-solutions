import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : s1.split(" ")) map.put(s, map.getOrDefault(s, 0) + 1);
    for (String s : s2.split(" ")) map.put(s, map.getOrDefault(s, 0) + 1);
    List<String> out = new ArrayList<>();
    for (Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) out.add(entry.getKey());
    }
    return out.toArray(String[]::new);
  }
}

// //few lines with streams

// class Solution {
//   public String[] uncommonFromSentences(String s1, String s2) {
//     Map<String, Integer> map = new HashMap<>();
//     for (String s : s1.split(" ")) map.put(s, map.getOrDefault(s, 0) + 1);
//     for (String s : s2.split(" ")) map.put(s, map.getOrDefault(s, 0) + 1);
//     return map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).toArray(String[]::new);
//   }
// }

// //this is a tiny bit better memory wise

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Solution {
//   public String[] uncommonFromSentences(String s1, String s2) {
//     StringBuilder sb = new StringBuilder();
//     sb.append(s1);
//     sb.append(" ");
//     sb.append(s2);
//     String[] splitted = sb.toString().split(" ");
//     Arrays.sort(splitted);
//     List<String> result = new ArrayList<>();
//     if (!splitted[0].equals(splitted[1])) result.add(splitted[0]);
//     for (int i = 1; i < splitted.length - 1; i++) {
//       if (!splitted[i - 1].equals(splitted[i]) && !splitted[i].equals(splitted[i + 1])) result.add(splitted[i]);
//     }
//     if (!splitted[splitted.length - 1].equals(splitted[splitted.length - 2])) result.add(splitted[splitted.length - 1]);
//     return result.toArray(new String[result.size()]);
//   }
// }