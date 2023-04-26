class Solution {
  public int addDigits(int num) {
    String n = Integer.toString(num);
    int sum = 0;
    while (num > 9) {
      for (int i = 0; i < n.length(); i++) {
        sum += Integer.parseInt(n.charAt(i) + "");
      }
      num = sum;
      sum = 0;
      n = Integer.toString(num);
    }
    return num;
  }
}