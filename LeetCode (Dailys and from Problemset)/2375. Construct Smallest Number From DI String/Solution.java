class Solution {
  public String smallestNumber(String pattern) {
    int min = 1;
    StringBuilder res = new StringBuilder();
    int decrementBuffer = 0;
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (c == 'I') {
        int newMin = min + 1 + decrementBuffer;
        while (decrementBuffer > 0) {
          res.append(min + decrementBuffer--);
        }
        res.append(min);
        min = newMin;
      } else {
        decrementBuffer++;
      }
    }
    while (decrementBuffer >= 0) {
      res.append(min + decrementBuffer--);
    }
    return res.toString();
  }
}