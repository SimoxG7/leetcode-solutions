import java.util.HashSet;
import java.util.Set;

class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    Set<Character> brokenSet = new HashSet<>();
    for (int i = 0; i < brokenLetters.length(); i++) {
      brokenSet.add(brokenLetters.charAt(i));
    }
    String[] words = text.split(" ");
    int nonBrokenWords = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      boolean broken = false;
      for (int j = 0; j < word.length(); j++) {
        if (brokenSet.contains(word.charAt(j))) {
          broken = true;
          break;
        }
      }
      if (!broken) nonBrokenWords++;
    }
    return nonBrokenWords;
  }
}