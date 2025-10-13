import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<String> removeAnagrams(String[] words) {
    List<String> lst = new LinkedList<>();
    lst.add(words[0]);
    int[] prev = getCharCounterArray(words[0]), curr = null;
    for (int i = 1; i < words.length; i++) {
      curr = getCharCounterArray(words[i]);
      if (!areAnagrams(prev, curr)) {
        lst.add(words[i]);
        prev = curr;
      }
    }
    return lst;
  }

  private int[] getCharCounterArray(String word) {
    int[] charFrequencies = new int[26];
    for (int i = 0; i < word.length(); i++) {
      charFrequencies[word.charAt(i) - 'a']++;
    }
    return charFrequencies;
  }

  private boolean areAnagrams(int[] charFrequencies1, int[] charFrequencies2) {
    for (int i = 0; i < 26; i++) {
      if (charFrequencies1[i] != charFrequencies2[i]) return false;
    }
    return true;
  }
}