import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public String sortVowels(String s) {
    List<Character> vowels = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if ("aeiouAEIOU".indexOf(c) != -1) {
        vowels.add(c);
      }
    }
    Collections.sort(vowels, Collections.reverseOrder());

    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if ("aeiouAEIOU".indexOf(c) != -1) {
        result.append(vowels.get(vowels.size() - 1));
        vowels.remove(vowels.size() - 1);
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }
}