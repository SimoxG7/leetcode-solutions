class Solution {
  public String getHappyString(int n, int k) {
    String chars = "abc";
    StringBuilder s = new StringBuilder();
    String[] res = new String[] { "" };
    int[] count = new int[] { 0 };

    dfs(n, k, chars, 0, count, s, res);

    if (count[0] < k)
      return "";

    return res[0];
  }

  private void dfs(int n, int k, String chars, int index, int[] count, StringBuilder s, String[] res) {
    if (s.length() == n) {
      if (count[0] == k)
        res[0] = s.toString();
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (s.length() != 0 && s.charAt(index - 1) == chars.charAt(i))
        continue;

      s.append(chars.charAt(i));
      if (s.length() == n)
        count[0]++;
      dfs(n, k, chars, index + 1, count, s, res);
      if (!res[0].isEmpty())
        return;
      s.deleteCharAt(s.length() - 1);
    }
  }
}