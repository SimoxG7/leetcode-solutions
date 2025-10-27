class Solution {
  public int strongPasswordChecker(String password) {
    StringBuilder s = new StringBuilder(password);
    int adds = Math.max(6 - password.length(), 0);
    int edits = minimumEditsNeeded(s);
    int removes = Math.max(password.length() - 20, 0);
    if (adds == 0 && removes == 0) return edits;
    int operations = 0;
    if (adds > 0) {
      if (adds > edits) return adds;
      
    }
  }

  private boolean satisfiesRepetitionRequisites(StringBuilder password) {
    char currentChar = password.charAt(0);
    int repetitions = 1;
    for (int i = 1; i < password.length(); i++) {
      char newChar = password.charAt(i);
      if (currentChar == newChar) {
        repetitions++;
        if (repetitions == 3) return false;
      } else {
        currentChar = newChar;
        repetitions = 1;
      }
    }
    return true;
  }

  private int minimumEditsNeeded(StringBuilder password) {
    boolean containsLowercase = false, containsUppercase = false, containsDigit = false;
    int containCount = 0;
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (!containsLowercase && Character.isLowerCase(c)) {
        containsLowercase = true;
        containCount++;
        continue;
      }
      if (!containsUppercase && Character.isUpperCase(c)) {
        containsUppercase = true;
        containCount++;
        continue;
      }
      if (!containsDigit && Character.isDigit(c)) {
        containsUppercase = true;
        containCount++;
        continue;
      }
      if (containCount == 3) return 0;
    }
    return 3 - containCount;
  }
}