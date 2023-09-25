class Solution {
  public boolean isPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) stringBuilder.append(Character.toLowerCase(c));
    }
    String res = stringBuilder.toString();
    for (int i = 0; i < res.length()/2; i++) {
      if (res.charAt(i) != res.charAt(res.length() - i - 1)) return false;
    }
    return true;
    //return stringBuilder.toString().equals(stringBuilder.reverse().toString());
  }
}