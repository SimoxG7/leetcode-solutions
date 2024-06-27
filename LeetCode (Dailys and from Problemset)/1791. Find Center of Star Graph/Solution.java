class Solution {
  public int findCenter(int[][] edges) {
    int option1 = edges[0][0];
    int option2 = edges[0][1];
    if (edges[1][0] == option1 || edges[1][1] == option1) return option1;
    return option2;
  }
}