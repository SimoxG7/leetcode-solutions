import java.util.Stack;

class Solution {
  public int calculate(String s) {
    int res = 0;
    boolean positive = true;
    int currNum = 0;
    Stack<Integer> values = new Stack<>();
    Stack<Boolean> signs = new Stack<>();
    for (char c : s.toCharArray()) {
      System.out.println(c + "");
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + (c - '0');
      } else if (isOperation(c)) {
        int toAdd = positive ? currNum : -currNum;
        res += toAdd;
        currNum = 0;
        positive = c == '+' ? true : false;
      } else if (isOpenParenthesis(c)) {
        values.push(res);
        signs.push(positive);
        res = 0;
        positive = true;
      } else if (isClosedParenthesis(c)) {
        int toAdd = positive ? currNum : -currNum;
        res += toAdd;
        currNum = 0;
        if (!signs.pop()) res = -res;
        res += values.pop();
      }
    }
    if (positive) res += currNum;
    else res += -currNum;
    return res;
  }

  private boolean isOperation(char c) {
    return c == '-' || c == '+';
  }

  private boolean isOpenParenthesis(char c) {
    return c == '(';
  }

  private boolean isClosedParenthesis(char c) {
    return c == ')';
  }

}

