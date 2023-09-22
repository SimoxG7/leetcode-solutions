import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int maxProduct(String[] words) {
    List<Set<Character>> all = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      Set<Character> temp = new HashSet<>();
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        char c = word.charAt(j);
        temp.add(c);
      }
      all.add(temp);
    }
    int currmax = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        boolean broken = false;
        for (Character c : all.get(i)) {
          if (all.get(j).contains(c)) {
            broken = true;
            break;
          }
        }
        if (!broken) {
          currmax = Math.max(currmax, words[i].length() * words[j].length());
        }
      }
    }
    return currmax;
  }
}