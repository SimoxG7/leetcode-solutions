class Solution {
  public String smallestPalindrome(String s) {
    int totLen = s.length();
    if (totLen <= 3) return s;
    boolean isOdd = totLen % 2 == 1;
    int halfLen = totLen / 2;

    int[] count = new int[26];
    for (int i = 0; i < halfLen; i++) {
      count[s.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      String targetString = String.valueOf((char) ('a' + i)).repeat(count[i]);
      sb.append(targetString);
    }

    return sb.toString() + (isOdd ? s.charAt(halfLen) : "") + sb.reverse().toString();
  }
}