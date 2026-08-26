class Solution {
  public String shortestBeautifulSubstring(String s, int k) {
    int oneCounter = 0;
    char[] stringCharArray = s.toCharArray();

    String min = "";
    int minLenght = Integer.MAX_VALUE;
    int left = 0, right = 0;

    while (right < stringCharArray.length) {
      if (stringCharArray[right++] != '1')
        continue;

      oneCounter++;

      while (oneCounter > k)
        if (stringCharArray[left++] == '1')
          oneCounter--;

      while (stringCharArray[left] != '1')
        left++;

      if (oneCounter == k) {
        int newLength = right - left;
        if (newLength > minLenght)
          continue;

        String newMinCandidate = s.substring(left, right);

        if (newLength < minLenght) {
          min = newMinCandidate;
          minLenght = min.length();
        } else
          min = min.compareTo(newMinCandidate) <= 0 ? min : newMinCandidate;

      }
    }

    return min;
  }
}