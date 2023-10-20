import java.util.Stack;

class Solution {
  public boolean backspaceCompare(String s, String t) {
    final char backSpace = '#';
    Stack<Character> stackS = new Stack<>();
    Stack<Character> stackT = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == backSpace) {
        if (!stackS.empty()) stackS.pop();
      } else {
        stackS.push(c);
      }
    }
    for (char c : t.toCharArray()) {
      if (c == backSpace) {
        if (!stackT.empty()) stackT.pop();
      } else {
        stackT.push(c);
      }
    }
    StringBuilder resS = new StringBuilder();
    StringBuilder resT = new StringBuilder();
    while (!stackS.empty()) {
      resS.append(stackS.pop());
    }
    while (!stackT.empty()) {
      resT.append(stackT.pop());
    }
    return resS.toString().equals(resT.toString());
  }
}