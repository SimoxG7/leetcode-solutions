class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {
    int oddCounter = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] & 1) == 1) {
        oddCounter++;
        if (oddCounter >= 3) return true;
      }
      else {
        oddCounter = 0;
      }
    }
    return false;
  }
}