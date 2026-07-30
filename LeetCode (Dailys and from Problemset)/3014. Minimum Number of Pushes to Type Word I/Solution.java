class Solution {
  public int minimumPushes(String word) {
    int n = word.length();
    int rem = n % 8;
    int comp = n / 8;

    return 8 * comp * (comp + 1) / 2 + (comp + 1) * rem;
  }
}

// import java.util.Arrays;
// import java.util.Comparator;

// class Solution {
// public int minimumPushes(String word) {
// int[] occurr = new int[26];
// for (char c : word.toCharArray()) {
// occurr[c - 'a']++;
// }

// int[] sorted = Arrays.stream(occurr)
// .boxed()
// .sorted(Comparator.reverseOrder())
// .mapToInt(Integer::intValue)
// .toArray();

// int accumulator = 0;
// int index = 0;
// while (index < 26) {
// int pushes = sorted[index];
// if (pushes == 0) break;
// accumulator += pushes * ((index / 8) + 1);
// index++;
// }
// return accumulator;
// }
// }