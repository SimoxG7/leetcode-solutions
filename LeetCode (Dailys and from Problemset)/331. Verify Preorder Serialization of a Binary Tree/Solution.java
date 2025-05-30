class Solution {

  public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    final String nullValue = "#";
    int diff = 1;
    for (String node : nodes) {
      if (--diff < 0)
        return false;
      if (!node.equals(nullValue))
        diff += 2;
    }
    return diff == 0;
  }
}