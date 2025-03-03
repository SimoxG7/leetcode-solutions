class Solution {
  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
        if (isValid(num, i, j))
          return true;
      }
    }
    return false;
  }

  private boolean isValid(String num, int i, int j) {
    if (i > 1 && num.charAt(0) == '0')
      return false;
    if (j > 1 && num.charAt(i) == '0')
      return false;

    Long x1 = Long.parseLong(num.substring(0, i));
    Long x2 = Long.parseLong(num.substring(i, i + j));

    return checkAdditive(x1, x2, i + j, num);
  }

  private boolean checkAdditive(Long x1, Long x2, int start, String num) {
    while (start < num.length()) {
      Long sum = x1 + x2;
      String sumStr = sum.toString();

      if (!num.startsWith(sumStr, start))
        return false;

      x1 = x2;
      x2 = sum;
      start += sumStr.length();
    }
    return true;
  }
}