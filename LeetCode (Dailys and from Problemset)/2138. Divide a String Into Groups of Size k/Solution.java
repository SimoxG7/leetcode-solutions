class Solution {
  public String[] divideString(String s, int k, char fill) {
    int len = s.length();
    int groups = len / k;
    boolean hasMore = len % k != 0;
    String[] res = new String[groups + (hasMore ? 1 : 0)];
    for (int i = 0; i < groups; i++) {
      res[i] = s.substring(i * k, (i + 1) * k);
    }
    if (hasMore) {
      res[res.length - 1] = s.substring(groups * k) + (fill + "").repeat(k - len % k);
    }
    return res;
  }
}