class Solution {

  public char processStr(String s, long k) {
    int n = s.length();
    long length = 0;

    for (char c : s.toCharArray()) {
      switch (c) {
        case '*' -> {
          if (length > 0) length--;
        }
        case '#' -> length *= 2;
        case '%' -> {}
        default -> length++;
      }
    }

    if (k >= length) return '.';

    for (int i = n - 1; i >= 0; i--) {
      char c = s.charAt(i);
      switch (c) {
        case '*' -> length++;
        case '%' -> k = length - k - 1;
        case '#' -> {
          length /= 2;
          if (k >= length) {
            k -= length;
          }
        }
        default -> length--;
      }

      if (k == length) return c;
    }
    return '.';
  }
}