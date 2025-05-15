import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> getLongestSubsequence(String[] words, int[] groups) {
    List<String> lst = new ArrayList<>();
    int n = words.length;
    lst.add(words[0]);
    for (int i = 1; i < n; i++) {
      if (groups[i] != groups[i - 1]) lst.add(words[i]);
    }
    return lst;
  }
}