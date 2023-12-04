class Solution {
  public String largestGoodInteger(String num) {
    int best = -1;
    int base = 3;
    for (int i = 0; i < num.length() - base + 1; i++) {
      String newnum = num.substring(i, i + base);
      int n = Integer.parseInt(newnum);
      if (n == 0 || (n % 111 == 0 && n > 110)) best = Math.max(best, n);
    }
    if (best == 0) return "000";
    return (best == -1) ? "" : "" +  best; 
  }
}