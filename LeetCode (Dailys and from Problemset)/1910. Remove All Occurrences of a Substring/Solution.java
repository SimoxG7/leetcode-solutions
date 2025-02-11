import java.lang.StringBuilder;

class Solution {
  public String removeOccurrences(String s, String part) {
    StringBuilder sb = new StringBuilder(s);
    int len = part.length();
    while (sb.indexOf(part) != -1) {
      int index = sb.indexOf(part);
      sb.delete(index, index + len);
    }
    return sb.toString();
  }
}