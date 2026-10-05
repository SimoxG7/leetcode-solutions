import java.util.ArrayDeque;

class Solution {
  public int scoreOfParentheses(String s) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(0);

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(0);
      } else {
        int curr = stack.pop();
        if (curr == 0)
          curr = 1;
        else
          curr *= 2;
        stack.push(stack.pop() + curr);
      }
    }
    return stack.pop();
  }
}
