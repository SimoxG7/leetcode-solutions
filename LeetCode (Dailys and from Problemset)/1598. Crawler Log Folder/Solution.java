class Solution {
  public int minOperations(String[] logs) {
    int depth = 0;
    for (int i = 0; i < logs.length; i++) {
      if (logs[i].equals("../")) {
        depth = Math.max(0, depth-1);
      } else if (!logs[i].equals("./")) {
        depth++;
      }
    }
    return depth;
  }
}