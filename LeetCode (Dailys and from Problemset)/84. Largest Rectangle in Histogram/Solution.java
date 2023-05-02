import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
    int[] nse = new int[heights.length];
    int[] pse = new int[heights.length];
    Stack<Integer> st = new Stack<>();
    nse[0] = -1;
    st.push(0);
    for (int i = 1; i < heights.length; i++) {
      while (st.size() > 0 && heights[i] <= heights[st.peek()]) st.pop();
      if (st.size() == 0) nse[i] = (-1);
      else nse[i] = st.peek();
      st.push(i);
    }
    st.clear();
    st.push(heights.length - 1);
    pse[heights.length - 1] = heights.length;
    for (int i = heights.length - 2; i >= 0; i--) {
      while (st.size() > 0 && heights[i] <= heights[st.peek()]) st.pop();
      if (st.size() == 0) pse[i] = heights.length;
      else pse[i] = st.peek();
      st.push(i);
    }
    int maxarea = 0;
    for (int i = 0; i < heights.length; i++) {
      maxarea = Math.max(maxarea, (pse[i] - nse[i] - 1) * heights[i]);
    }
    return maxarea;
  }
}