class Solution {

  public int numEquivDominoPairs(int[][] dominoes) {
    int[] num = new int[100];
    int count = 0;
    for (int[] domino : dominoes) {
      int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
      count += num[val];
      num[val]++;
    }
    return count;
  }
}