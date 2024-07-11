import java.util.Stack;

class Solution {
  public String reverseParentheses(String s) {
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        while (stack.peek() != '(') {
          result.append(stack.pop());
        }
        stack.pop();
        while (result.length() > 0) {
          stack.push(result.charAt(0));
          result.deleteCharAt(0);
        }
      } else {
        stack.push(s.charAt(i));
      }
    }
    while (!stack.isEmpty()) {
      result.insert(0, stack.pop());
    }

    return result.toString();
  }
}