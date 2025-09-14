import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    Map<String, List<Integer>> generalizedWordToWordlistIndexes = new HashMap<>();
    for (int i = 0; i < wordlist.length; i++) {
      String generalizedWord = generalizeWord(wordlist[i]);
      List<Integer> indexesSet = generalizedWordToWordlistIndexes.getOrDefault(generalizedWord, new ArrayList<>());
      indexesSet.add(i);
      generalizedWordToWordlistIndexes.put(generalizedWord, indexesSet);
    }

    int n = queries.length;
    String[] queryResults = new String[n];
    for (int i = 0; i < n; i++) {
      String generalizedQueryWord = generalizeWord(queries[i]);
      if (!generalizedWordToWordlistIndexes.containsKey(generalizedQueryWord)) {
        queryResults[i] = "";
        continue;
      }

      List<Integer> validIndexes = generalizedWordToWordlistIndexes.get(generalizedQueryWord);
      boolean found = false;

      // Look for exact match
      for (int index : validIndexes) {
        if (wordlist[index].equals(queries[i])) {
          queryResults[i] = wordlist[index];
          found = true;
          break;
        }
      }
      if (found) continue;

      // Look for case match
      for (int index : validIndexes) {
        String lowerCaseQueryWord = queries[i].toLowerCase();
        if (wordlist[index].toLowerCase().equals(lowerCaseQueryWord)) {
          queryResults[i] = wordlist[index];
          found = true;
          break;
        }
      }
      if (found) continue;

      // Take first acceptable from generalized
      queryResults[i] = wordlist[validIndexes.get(0)];
    }
    return queryResults;
  }

  private String generalizeWord(String word) {
    StringBuilder s = new StringBuilder();
    word = word.toLowerCase();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (isVowel(c)) s.append("*");
      else s.append(c);
    }
    return s.toString();
  }

  private boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
  }
}