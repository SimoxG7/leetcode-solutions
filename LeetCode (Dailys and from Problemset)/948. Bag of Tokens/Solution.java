import java.util.Arrays;

class Solution {
  public int bagOfTokensScore(int[] tokens, int power) {

    Arrays.sort(tokens);
    int min = 0, max = tokens.length - 1;

    int maxScore = 0;
    int score = 0;

    while (min <= max) {
      if (power >= tokens[min]) {
        power -= tokens[min];
        score++;
        maxScore = Math.max(score, maxScore);
        min++;
        continue;
      } else {
        if (score >= 1) {
          power += tokens[max];
          max--;
          score--;
          continue;
        }
      }
      break;
    }
    return maxScore;
  }
}