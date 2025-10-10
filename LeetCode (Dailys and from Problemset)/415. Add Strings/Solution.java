class Solution {
  public String addStrings(String num1, String num2) {
    StringBuilder s = new StringBuilder();
    int carry = 0;
    int index = 0;
    int len1 = num1.length(), len2 = num2.length();
    while (index < len1 && index < len2) {
      int num1Digit = num1.charAt(len1 - index - 1) - '0';
      int num2Digit = num2.charAt(len2 - index - 1) - '0';
      int sum = num1Digit + num2Digit + carry;
      carry = sum / 10;
      s.append(sum % 10);
      index++;
    }
    while (index < len1) {
      int numDigit = num1.charAt(len1 - index - 1) - '0';
      int sum = numDigit + carry;
      carry = sum / 10;
      s.append(sum % 10);
      index++;
    }
    while (index < len2) {
      int numDigit = num2.charAt(len2 - index - 1) - '0';
      int sum = numDigit + carry;
      carry = sum / 10;
      s.append(sum % 10);
      index++;
    }
    if (carry > 0) s.append(carry);
    return s.reverse().toString();
  }
}