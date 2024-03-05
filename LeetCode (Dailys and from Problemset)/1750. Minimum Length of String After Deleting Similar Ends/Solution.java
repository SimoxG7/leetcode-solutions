class Solution {
  public int minimumLength(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }

      char ch = s.charAt(left);
      while (left < right && s.charAt(left) == ch)
        left++;
      while (right >= left && s.charAt(right) == ch)
        right--;
    }
    return right - left + 1;
  }
}
