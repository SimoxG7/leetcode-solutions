import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public List<String> commonChars(String[] words) {
    List<String> res = new ArrayList<>();
    int numWords = words.length;
    Map<Character, Integer> mainMap = createCharMap(words[0]);
    for (int i = 1; i < numWords; i++) {
      Map<Character, Integer> newMap = createCharMap(words[i]);
      for (Entry<Character, Integer> entry : newMap.entrySet()) {
        Character key = entry.getKey();
        if (mainMap.containsKey(key)) {
          mainMap.put(key, Math.min(entry.getValue(), newMap.get(key)));
        } else {
          mainMap.remove(key);
        }
      }
    }
    for (Entry<Character, Integer> entry : mainMap.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        String value = entry.getKey() + "";
        res.add(value);
      }
    }
    return res;
  }

  Map<Character, Integer> createCharMap(String word) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }
}