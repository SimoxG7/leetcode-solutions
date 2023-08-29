import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
  public String reverseVowels(String s) {
    Set<Character> vowels = new HashSet<>();
    vowels.addAll(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    List<Character> toAdd = new LinkedList<>(); 
    for (int i = 0; i < s.length(); i++) {
      if (vowels.contains(s.charAt(i))) {
        toAdd.add(s.charAt(i));
      }
    }
    Collections.reverse(toAdd);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (vowels.contains(s.charAt(i))) stringBuilder.append(toAdd.remove(0));
      else stringBuilder.append(s.charAt(i));
    }
    return stringBuilder.toString();
  }
}