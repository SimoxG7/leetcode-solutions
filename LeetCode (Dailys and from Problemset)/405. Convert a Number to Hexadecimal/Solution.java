class Solution {
  public String toHex(int num) {
    if (num == 0) return "0";
    
    char[] hexChars = "0123456789abcdef".toCharArray();
    StringBuilder sb = new StringBuilder();

    // Handle negative numbers using 32-bit two's complement
    int n = num;
    while (n != 0 && sb.length() < 8) { // at most 8 hex digits
      int digit = n & 0xF; // get last 4 bits
      sb.append(hexChars[digit]);
      n >>>= 4; // unsigned shift
    }

    return sb.reverse().toString();
  }
}

// class Solution {
// public String toHex(int num) {
// if (num == 0) return "0";
// long n = num;
// StringBuilder stringBuilder = new StringBuilder();
// // if (n < 0) n = (~n) + 1; // Two's complement
// int shifts = 0;
// while (n != 0 && shifts++ < 8) {
// stringBuilder.append(fourBitsGroupToHex(n & 0b1111));
// n >>= 4;
// }
// return stringBuilder.reverse().toString();
// }

// private String fourBitsGroupToHex(long numFourBits) {
// if (numFourBits < 10L) return Long.toString(numFourBits);
// return (char) (numFourBits - 10L + 'a') + "";
// }
// }