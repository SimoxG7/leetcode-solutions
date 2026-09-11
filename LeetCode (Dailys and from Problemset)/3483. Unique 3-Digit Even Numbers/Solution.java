class Solution {
  public int totalNumbers(int[] digits) {
    int[] digitsCount = new int[10];
    for (int digit : digits) {
      digitsCount[digit]++;
    }

    int possibleNumsCount = 0;
    for (int hundredDigit = 1; hundredDigit <= 9; hundredDigit++) {
      if (digitsCount[hundredDigit] == 0) continue;
      digitsCount[hundredDigit]--;

      for (int tensDigit = 0; tensDigit <= 9; tensDigit++) {
        if (digitsCount[tensDigit] == 0) continue;
        digitsCount[tensDigit]--;

        for (int unitDigit = 0; unitDigit <= 8; unitDigit += 2) {
          if (digitsCount[unitDigit] > 0) {
            possibleNumsCount++;
          }
        }
        digitsCount[tensDigit]++;
      }
      digitsCount[hundredDigit]++;
    }

    return possibleNumsCount;
  }
}