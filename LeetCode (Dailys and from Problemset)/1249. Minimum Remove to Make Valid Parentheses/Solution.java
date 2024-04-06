class Solution {
  public String minRemoveToMakeValid(String s) {
    StringBuilder sb = new StringBuilder(s);
    int cont = 0;
    int index = 0;
    while (index < sb.length()) {
      if (sb.charAt(index) == '(') cont++;
      else if (sb.charAt(index) == ')') {
        if (cont > 0) cont--;
        else {
          sb.deleteCharAt(index);
          index--;
        }
      }
      index++;
    }
    index = sb.length() - 1;
    while (cont > 0) {
      if (sb.charAt(index) == '(') {
        sb.deleteCharAt(index);
        cont--;
      }
      index--;
    }
    return sb.toString();
  }
}