class Solution {
  public int getLucky(String s, int k) {
    String sum = "";
    for (int i = 0; i < s.length(); i++) {
      sum += s.charAt(i) - 96;
    }
    int res = 0;
    for (int i = 0; i < k; i++) {
      res = 0;
      for (int j = 0; j < sum.length(); j++) {
        res += Integer.parseInt(sum.charAt(j) + "");
      }
      sum = Integer.toString(res);
    }
    return res;
  }
}