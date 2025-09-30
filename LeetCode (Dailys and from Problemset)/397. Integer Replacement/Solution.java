class Solution {
  public int integerReplacement(int n) {
    long num = n;
    int counter = 0;
    while (num > 1) {
      counter++;
      if (num % 2 == 0) num >>= 1;
      else {
        if (num == 3 || (num & 0b11) == 0b01) num--;
        else num++;
      }
    }
    return counter;
  }
}

// About Bit Manipulation solution.

// Adding 1 when the last bit is 11 will result in an even number that is divisible by 4
// Subtracting 1 when the last bit is 01 will result in an even number that is divisible by 2

// Even: Use one right shift (>> 1) instead of dividing by 2
// Odd: Check the bits to decide whether to add or subtract 1:
// Special case: If n = 3, decrement (because 3 → 2 → 1 is better than 3 → 4 → 2 → 1)
// When the last 2 bits are 11 (n % 4 == 3): Add 1
// Other: Subtract 1
