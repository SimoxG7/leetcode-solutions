import java.util.Arrays;

class Solution {
  public int minimumDeletions(String word, int k) {

    int[] arr = new int[26];
    int uniqueCharacters = 0;
    for (char ch : word.toCharArray()) {
      if (arr[(int) (ch - 'a')] == 0)
        uniqueCharacters++;
      arr[(int) (ch - 'a')]++;
    }

    int[] frequency = new int[uniqueCharacters];
    int idx = 0;
    for (int count : arr) {
      if (count > 0) {
        frequency[idx++] = count;
      }
    }

    Arrays.sort(frequency);

    int minDeletions = Integer.MAX_VALUE;

    for (int i = 0; i < frequency.length; i++) {
      int baseFreq = frequency[i];
      int deletions = 0;

      for (int j = 0; j < frequency.length; j++) {
        if (frequency[j] < baseFreq) {
          deletions += frequency[j];
        } else if (frequency[j] > baseFreq + k) {
          deletions += frequency[j] - (baseFreq + k);
        }
      }
      minDeletions = Math.min(minDeletions, deletions);
    }
    return minDeletions;
  }
}