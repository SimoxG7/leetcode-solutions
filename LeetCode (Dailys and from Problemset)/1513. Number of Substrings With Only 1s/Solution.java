class Solution {
  public int numSub(String s) {
    int totalCount = 0;
    int count = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '1') {
        count++;
      } else {
        totalCount = (totalCount + (int) noOfSubArr(count)) % 1000000007;
        count = 0;
      }
    }
    totalCount += noOfSubArr(count);
    return totalCount;
  }

  public long noOfSubArr(int N) {
    return ((long) N * ((long) N + 1) / 2) % 1000000007;
  }
}