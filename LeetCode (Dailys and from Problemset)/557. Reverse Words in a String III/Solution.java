class Solution {
  public String reverseWords(String s) {
    String[] splitted = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String inner : splitted) {
      stringBuilder.append(new StringBuilder(inner).reverse().toString());
      stringBuilder.append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
    return stringBuilder.toString();
  }
}