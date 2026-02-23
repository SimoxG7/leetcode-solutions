import java.util.Set;
import java.util.HashSet;

class Solution {
  public boolean hasAllCodes(String s, int k) {
    int allCodesSize = 1 << k;
    Set<String> codes = new HashSet<>();
    for (int i = 0; i < s.length() - k + 1; i++) {
      String subString = s.substring(i, i + k);
      if (codes.add(subString)) {
        if (codes.size() == allCodesSize) return true;
      }
    }
    return false;
  }
}