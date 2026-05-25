class Solution {
  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length();

    int[] diffArr = new int[n + 1];

    int currSum = 0;

    for (int i = 0; i < n; i++) {
      currSum += diffArr[i];

      if (s.charAt(i) == '1')
        continue;
      
      if (i > 0 && currSum <= 0)
        continue;

      if (i == n - 1)
        return true;

      int start = Math.min(n, i + minJump);
      int end = Math.min(n, i + maxJump + 1);

      diffArr[start] += 1;
      diffArr[end] -= 1;
    }

    return false;
  }
}