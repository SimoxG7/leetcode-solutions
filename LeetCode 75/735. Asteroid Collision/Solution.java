import java.util.Stack;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < asteroids.length; i++) {
      if (st.isEmpty() || asteroids[i] > 0) {
        st.push(asteroids[i]);
      } else {
        while (true) {
          int peek = st.peek();
          if (peek < 0) {
            st.push(asteroids[i]);
            break;
          } else if (peek == -asteroids[i]) {
            st.pop();
            break;
          } else if (peek > -asteroids[i]) {
            break;
          } else {
            st.pop();
            if (st.isEmpty()) {
              st.push(asteroids[i]);
              break;
            }
          }
        }
      }
    }
    int[] res = new int[st.size()];
    for (int i = st.size() - 1; i >= 0; i--) {
      res[i] = st.pop();
    }
    return res;
  }
}


// import java.util.Stack;

// class Solution {
// public int[] asteroidCollision(int[] asteroids) {
// Stack<Integer> stack = new Stack<>();
// for (int ast : asteroids) {
// if (stack.empty()) stack.push(ast);
// else if (stack.peek() * ast < 0) {
// while (stack.peek() * ast < 0) {
// int abssum = Math.abs(stack.peek()) - Math.abs(ast);
// if (abssum == 0) {
// stack.pop();
// break;
// } else if (abssum < 0) {
// stack.pop();
// } else break;
// }
// } else stack.push(ast);
// }
// int[] res = new int[stack.size()];
// for (int i = res.length-1; i >= 0; i--) {
// res[i] = stack.pop();
// }
// return res;
// }
// }