public class Solution {
  public int strongPasswordChecker(String s) {

    if (s.length() < 2)
      return 6 - s.length();

    // Initialize the states, including current ending character(end), existence of
    // lowercase letter(lower), uppercase letter(upper), digit(digit) and number of
    // replicates for ending character(end_rep)
    char end = s.charAt(0);
    boolean upper = end >= 'A' && end <= 'Z', lower = end >= 'a' && end <= 'z', digit = end >= '0' && end <= '9';

    // Also initialize the number of modification for repeated characters, total
    // number needed for eliminate all consequnce 3 same character by
    // replacement(change), and potential maximun operation of deleting
    // characters(delete). Note delete[0] means maximum number of reduce 1
    // replacement operation by 1 deletion operation, delete[1] means maximun number
    // of reduce 1 replacement by 2 deletion operation, delete[2] is no use here.
    int end_rep = 1, change = 0;
    int[] delete = new int[3];

    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == end)
        ++end_rep;
      else {
        change += end_rep / 3;
        if (end_rep / 3 > 0)
          ++delete[end_rep % 3];
        // updating the states
        end = s.charAt(i);
        upper = upper || end >= 'A' && end <= 'Z';
        lower = lower || end >= 'a' && end <= 'z';
        digit = digit || end >= '0' && end <= '9';
        end_rep = 1;
      }
    }
    change += end_rep / 3;
    if (end_rep / 3 > 0)
      ++delete[end_rep % 3];

    // The number of replcement needed for missing of specific
    // character(lower/upper/digit)
    int check_req = (upper ? 0 : 1) + (lower ? 0 : 1) + (digit ? 0 : 1);

    if (s.length() > 20) {
      int del = s.length() - 20;

      // Reduce the number of replacement operation by deletion
      if (del <= delete[0])
        change -= del;
      else if (del - delete[0] <= 2 * delete[1])
        change -= delete[0] + (del - delete[0]) / 2;
      else
        change -= delete[0] + delete[1] + (del - delete[0] - 2 * delete[1]) / 3;

      return del + Math.max(check_req, change);
    } else
      return Math.max(6 - s.length(), Math.max(check_req, change));
  }
}

// class Solution {
// public int strongPasswordChecker(String password) {
// StringBuilder s = new StringBuilder(password);
// int adds = Math.max(6 - password.length(), 0);
// int removes = Math.max(password.length() - 20, 0);
// int edits = minimumEditsNeeded(s);
// int repetitionEdits = minimumRepetitionEditsNeeded(s);
// int maxEdits = Math.max(edits, repetitionEdits);
// System.out.println("LENGHT: " + s.length());
// System.out.println("ADDS: " + adds);
// System.out.println("REMOVES: " + removes);
// System.out.println("EDITS: " + edits);
// System.out.println("REPETITIONEDITS: " + repetitionEdits);
// System.out.println("MAXEDITS: " + maxEdits);
// if (adds == 0 && removes == 0) return maxEdits;
// if (adds > 0) {
// return Math.max(maxEdits, adds);
// } else {
// return removes + maxEdits;
// }
// }

// private int minimumRepetitionEditsNeeded(StringBuilder password) {
// char currentChar = password.charAt(0);
// int minimumEdits = 0, repetitions = 1;
// for (int i = 1; i < password.length(); i++) {
// char newChar = password.charAt(i);
// if (currentChar == newChar) {
// repetitions++;
// if (repetitions == 3) {
// minimumEdits++;
// if (++i < password.length()) newChar = password.charAt(i);
// repetitions = 1;
// }
// } else {
// currentChar = newChar;
// repetitions = 1;
// }
// }
// return minimumEdits;
// }

// private int minimumEditsNeeded(StringBuilder password) {
// boolean containsLowercase = false, containsUppercase = false, containsDigit =
// false;
// int containCount = 0;
// for (int i = 0; i < password.length(); i++) {
// char c = password.charAt(i);
// if (!containsLowercase && Character.isLowerCase(c)) {
// containsLowercase = true;
// containCount++;
// continue;
// }
// if (!containsUppercase && Character.isUpperCase(c)) {
// containsUppercase = true;
// containCount++;
// continue;
// }
// if (!containsDigit && Character.isDigit(c)) {
// containsUppercase = true;
// containCount++;
// continue;
// }
// if (containCount == 3) return 0;
// }
// return 3 - containCount;
// }
// }