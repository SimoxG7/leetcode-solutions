class Solution {
  public String reverseWords(String s) {
    String[] splStrings = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = splStrings.length - 1; i >= 0; i--) {
      if (!splStrings[i].isBlank()) stringBuilder.append(splStrings[i]).append(" ");
    }
    return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
  }
}