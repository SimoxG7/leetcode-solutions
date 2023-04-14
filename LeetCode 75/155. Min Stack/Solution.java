import java.util.ArrayList;
import java.util.List;

class MinStack {

  List<Integer> stack;
  int min;

  public MinStack() {
    stack = new ArrayList<>();
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    stack.add(val);
    min = Math.min(min, val);
  }

  public void pop() {
    int last = stack.get(stack.size()-1);
    stack.remove(stack.size()-1);
    if (last == min) {
      int newmin = Integer.MAX_VALUE;
      for (int curr : stack) {
        newmin = Math.min(curr, newmin);
      }
      min = newmin;
    }
  }

  public int top() {
    return stack.get(stack.size()-1);
  }

  public int getMin() {
    return min;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */