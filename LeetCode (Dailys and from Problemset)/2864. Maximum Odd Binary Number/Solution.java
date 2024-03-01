class Solution {
  public String maximumOddBinaryNumber(String s) {
    int zeros = 0;
    int ones = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') zeros++;
      else ones++;
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("1".repeat(ones));
    stringBuilder.append("0".repeat(zeros));
    stringBuilder.append("1");
    return stringBuilder.toString();
  }
}