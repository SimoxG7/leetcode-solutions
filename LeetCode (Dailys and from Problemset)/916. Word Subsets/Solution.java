import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> wordSubsets(String[] words1, String[] words2) {
    List<String> result = new ArrayList<>();
    int[] hashDict = new int[26];
    for (String s : words2) {
      int[] hash = new int[26];
      for (char c : s.toCharArray()) {
        hash[c - 'a']++;
      }

      for (int i = 0; i < 26; i++) {
        hashDict[i] = Math.max(hashDict[i], hash[i]);
      }
    }

    for (String s : words1) {
      int[] hash = new int[26];
      for (char ch : s.toCharArray()) {
        hash[ch - 'a']++;
      }

      if (subset(hash, hashDict)) {
        result.add(s);
      }
    }

    return result;
  }

  private boolean subset(int[] hash, int[] hashDict) {
    for (int i = 0; i < 26; i++) {
      if (hashDict[i] > hash[i]) {
        return false;
      }
    }
    return true;
  }
}