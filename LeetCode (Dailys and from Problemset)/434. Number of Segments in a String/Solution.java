class Solution {
  public int countSegments(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;

    int startIndex = -1;
    for (int i = 0; i < len; i++) {
      if (chars[i] != ' ') {
        startIndex = i;
        break;
      }
    }

    if (startIndex == -1) return 0;
    
    boolean isPreviousSpace = true;
    int segments = 0;
    for (int i = startIndex; i < len; i++) {
      char c = chars[i];
      if (c != ' ') {
        if (isPreviousSpace) {
          isPreviousSpace = false;
          segments++;
        }
      } else isPreviousSpace = true;
    }

    return segments;
  }
}