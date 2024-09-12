import java.util.HashSet;
import java.util.Set;

class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    Set<Character> allowedSet = new HashSet<>();
    for (int i = 0; i < allowed.length(); i++) {
      allowedSet.add(allowed.charAt(i));
    }
    int count = 0;
    for (String word : words) {
      Set<Character> wordSet = new HashSet<>();
      for (int i = 0; i < word.length(); i++) {
        wordSet.add(word.charAt(i));
      }
      if (allowedSet.containsAll(wordSet)) count++;
    }
    return count;
  }
}