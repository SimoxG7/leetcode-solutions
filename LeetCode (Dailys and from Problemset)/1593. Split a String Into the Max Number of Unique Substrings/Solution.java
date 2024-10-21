import java.util.HashSet;
import java.util.Set;

class Solution {
  public int maxUniqueSplit(String s) {
    return backtrack(0, s, new HashSet<>());
  }

  private int backtrack(int start, String s, Set<String> seen) {
    if (start == s.length()) {
      return 0;
    }
    int maxSplits = 0;
    for (int end = start + 1; end <= s.length(); end++) {
      String substring = s.substring(start, end);
      if (!seen.contains(substring)) {
        seen.add(substring);
        maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
        seen.remove(substring);
      }
    }
    return maxSplits;
  }
}