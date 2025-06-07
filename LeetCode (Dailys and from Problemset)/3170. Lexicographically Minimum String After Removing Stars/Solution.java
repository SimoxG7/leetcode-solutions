import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
  public String clearStars(String s) {
    Stack<Character> stack = new Stack<>();
    TreeMap<Character, List<Integer>> map = new TreeMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch != '*') {
        stack.push(ch);
        map.computeIfAbsent(ch, k -> new ArrayList<>()).add(stack.size() - 1);
      } else {

        char minChar = map.firstKey();
        List<Integer> indices = map.get(minChar);
        int indexToRemove = indices.remove(indices.size() - 1);

        stack.set(indexToRemove, null);

        if (indices.isEmpty()) {
          map.remove(minChar);
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (Character ch : stack) {
      if (ch != null && ch != '*') {
        result.append(ch);
      }
    }

    return result.toString();
  }
}