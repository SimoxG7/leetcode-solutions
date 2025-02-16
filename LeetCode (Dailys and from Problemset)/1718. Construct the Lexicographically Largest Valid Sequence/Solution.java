class Solution {
  public int[] constructDistancedSequence(int n) {
    int result[] = new int[2 * n - 1];
    boolean used[] = new boolean[n + 1];
    backtrack(result, used, 0, n);
    return result;
  }

  private boolean backtrack(int result[], boolean used[], int idx, int n) {
    if (idx == result.length) return true;
    if (result[idx] != 0) return backtrack(result, used, idx + 1, n);
    for (int num = n; num >= 1; num--) {
      int j = (num == 1) ? idx : idx + num; 
      if (!used[num] && (num == 1 || (j < result.length && result[j] == 0))) {
        result[idx] = num;
        if (num > 1) result[j] = num;
        used[num] = true;
        if (backtrack(result, used, idx + 1, n)) return true;
        result[idx] = 0;
        if (num > 1) result[j] = 0;
        used[num] = false;
      }
    }
    return false;
  }
}