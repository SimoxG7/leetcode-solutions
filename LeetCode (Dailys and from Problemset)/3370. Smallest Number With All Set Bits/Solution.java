class Solution {
  public int smallestNumber(int n) {
    return (1 << (Integer.SIZE - Integer.numberOfLeadingZeros(n))) - 1;
  }
}

// class Solution {
//   public int smallestNumber(int n) {
//     int setBits = 1;
//     for (int i = 0; i < 10; i++) { //as 1 <= n <= 1000 from constraints and 2^10 = 2024
//       int nextMinimumAllSetBits = (1 << setBits++) - 1;
//       if (n <= nextMinimumAllSetBits) return nextMinimumAllSetBits;
//     }
//     return (1 << 10) - 1; //unreachable by constraints
//   }
// }