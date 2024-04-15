import java.util.Stack;

class Solution {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int[] convertedArray = new int[m];
    for (int j = 0; j < m; j++) {
      convertedArray[j] = matrix[0][j] - '0';
    }
    int maxArea = largestRectangleArea(convertedArray); 
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0') convertedArray[j] = 0;
        else convertedArray[j] += matrix[i][j] - '0';
      }
      maxArea = Math.max(maxArea, largestRectangleArea(convertedArray));
    }
    return maxArea;
  }

  public int largestRectangleArea(int[] heights) {
    int n = heights.length, area = 0;
    Stack<Integer> s = new Stack<>();
    int[] nsl = new int[n];
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
      if (!s.isEmpty()) nsl[i] = s.peek();
      else nsl[i] = -1;
      s.push(i);
    }
    s = new Stack<>();
    int[] nsr = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
      if (!s.isEmpty()) nsr[i] = s.peek();
      else nsr[i] = n;
      s.push(i);
    }
    for (int i = 0; i < n; i++) {
      int hei = heights[i];
      int width = nsr[i] - nsl[i] - 1;
      int currArea = hei * width;
      area = Math.max(area, currArea);
    }
    return area;
  }
}