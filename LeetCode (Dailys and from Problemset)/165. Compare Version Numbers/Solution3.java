class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
    int v1Len = v1.length, v2Len = v2.length;
    boolean longestIsv1 = v1Len >= v2Len;
    int minLen = Math.min(v1Len, v2Len), maxLen = Math.max(v1Len, v2Len);
    for (int i = 0; i < minLen; i++) {
      int diff = fastStringNumberComparator(v1[i], v2[i]);
      if (diff != 0) return diff;
    }
    String[] longest = longestIsv1 ? v1 : v2;
    int longestResult = longestIsv1 ? 1 : -1;
    for (int i = minLen; i < maxLen; i++) {
      if (fastStringNumberComparator(longest[i], "0") != 0) return longestResult;
    }
    return 0;
  }

  private int fastStringNumberComparator(String num1, String num2) {
    String longest, shortest;
    boolean num1IsLongest = num1.length() >= num2.length();
    longest = num1IsLongest ? num1 : num2;
    shortest = num1IsLongest ? num2 : num1;
    int longestRes = num1IsLongest ? 1 : -1;
    int shortestRes = num1IsLongest ? -1 : 1;
    int lenDiff = longest.length() - shortest.length();
    for (int i = 0; i < lenDiff; i++) {
      if (longest.charAt(i) != '0') return longestRes;
    }
    for (int i = 0; i < shortest.length(); i++) {
      int charDiff = longest.charAt(i + lenDiff) - shortest.charAt(i);
      if (charDiff != 0) return charDiff > 0 ? longestRes : shortestRes;
    }
    return 0;
  }
}

// class Solution {
//   public int compareVersion(String version1, String version2) {
//     String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
//     int v1Len = v1.length, v2Len = v2.length;
//     boolean longestIsv1 = v1Len >= v2Len;
//     int minLen = Math.min(v1Len, v2Len), maxLen = Math.max(v1Len, v2Len);
//     for (int i = 0; i < minLen; i++) {
//       int diff = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);
//       if (diff != 0) return diff > 0 ? 1 : -1;
//     }
//     String[] longest = longestIsv1 ? v1 : v2;
//     int longestResult = longestIsv1 ? 1 : -1;
//     for (int i = minLen; i < maxLen; i++) {
//       if (Integer.parseInt(longest[i]) != 0) return longestResult;
//     }
//     return 0;
//   }
// }