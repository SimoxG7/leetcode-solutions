class Solution {
  public int closestTarget(String[] words, String target, int startIndex) {
    if (words[startIndex].equals(target)) return 0;
    int n = words.length, half = n / 2;
    int count = 0;
    int leftIndex = (startIndex - 1 + n) % n, rightIndex = (startIndex + 1) % n;
    while (count++ <= half) {
      if (words[leftIndex].equals(target) || words[rightIndex].equals(target)) return count;
      leftIndex = (leftIndex - 1 + n) % n;
      rightIndex = (rightIndex + 1) % n;
    }
    return -1;
  }
}