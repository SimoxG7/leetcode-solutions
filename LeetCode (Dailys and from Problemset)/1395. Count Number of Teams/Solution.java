class Solution {
  public int numTeams(int[] rating) {
    int answer = 0;
    answer = helper(rating);
    for (int i = 0; i < rating.length / 2; i++) {
      int temp = rating[i];
      rating[i] = rating[rating.length - i - 1];
      rating[rating.length - i - 1] = temp;
    }
    answer += helper(rating);
    return answer;
  }

  int helper(int[] rating) {
    int[] dp = new int[rating.length];
    int answer = 0;
    for (int i = 1; i < rating.length; i++) {
      for (int j = 0; j < i; j++) {
        if (rating[j] < rating[i]) {
          answer += dp[j];
          dp[i]++;
        }
      }
    }
    return answer;
  }
}