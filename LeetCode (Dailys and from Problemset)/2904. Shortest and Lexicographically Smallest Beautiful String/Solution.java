class Solution {
  public String shortestBeautifulSubstring(String s, int k) {
    int oneCounter = 0;
    char[] sCharArray = s.toCharArray();

    String min = "";
    int minLenght = Integer.MAX_VALUE;
    int sLength = sCharArray.length;
    int firstOneIndex = Integer.MAX_VALUE;
    int left = 0, right = 0;
    
    for (int i = 0; i < sLength; i++) {
      if (sCharArray[i] == '1') {
        firstOneIndex = Math.min(firstOneIndex, i);
        oneCounter++;
        if (oneCounter == k) {
          left = firstOneIndex;
          right = i + 1;
          min = s.substring(firstOneIndex, right);
          minLenght = min.length();
          break;
        }
      }
    }

    if (minLenght == Integer.MAX_VALUE) return "";

    while (right < sLength) {
      if (sCharArray[right] != '1') {
        right++;
        continue;
      }

      while (sCharArray[++left] != '1') {}
      right++;
      int newLength = right - left;
      if (newLength < minLenght) {
        min = s.substring(left, right);
        minLenght = min.length();
      } else if (newLength == minLenght) {
        String newMinCandidate = s.substring(left, right);
        min = min.compareTo(newMinCandidate) <= 0 ? min : newMinCandidate;
      }
    }

    return min;
  }
}