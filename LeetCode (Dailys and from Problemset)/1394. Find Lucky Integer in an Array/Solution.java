class Solution {
  public int findLucky(int[] arr) {
    int[] freqMap = new int[501];
    for (int i = 0; i < arr.length; i++) {
      freqMap[arr[i]]++;
    }
    int max = -1;
    for (int i = 1; i <= 500; i++) {
      if (freqMap[i] == i) max = Math.max(max, i);
    }
    return max;
  }
}