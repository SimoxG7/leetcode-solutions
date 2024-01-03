class Solution {
  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) bulls++;
    }

    int[] occurrSecret = new int[26];
    int[] occurrGuess = new int[26];
    for (int i = 0; i < secret.length(); i++) {
      occurrSecret[secret.charAt(i) - '0']++;
      occurrGuess[guess.charAt(i) - '0']++;
    }

    for (int i = 0; i < 26; i++) {
      if (occurrGuess[i] >= occurrSecret[i]) cows += occurrSecret[i];
      else cows += occurrGuess[i];
    }

    StringBuilder sb = new StringBuilder();
    return sb.append(bulls).append("A").append(cows-bulls).append("B").toString();
  }
}
