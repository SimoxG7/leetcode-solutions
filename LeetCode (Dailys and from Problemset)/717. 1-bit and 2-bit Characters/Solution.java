class Solution {
  public boolean isOneBitCharacter(int[] bits) {
    int n = bits.length;
    if (n <= 2) return bits[0] == 0;
    int prevZeroIndex = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (bits[i] == 0) {
        prevZeroIndex = i;
        break;
      }
    }
    //now i know that from i + 1 to n - 2 there are only 1s:
    //if the number of ones is odd, then it must be a 10;
    //if the number of ones is even, then it must be a 0.
    return (n - 1 - (prevZeroIndex + 1)) % 2 == 0;
  }
}