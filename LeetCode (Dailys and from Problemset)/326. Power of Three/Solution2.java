class Solution {
  public boolean isPowerOfThree(int n) {
    // 1162261467 is 3^19, 3^20 is bigger than Integer.MAX_VALUE  
    return n > 0 &&  1162261467 % n == 0;
  }
}

// class Solution {
//   public boolean isPowerOfThree(int n) {
//     if (n == 0) return false;
//     while (n % 3 == 0) {
//       n /= 3;
//     }
//     return n == 1;
//   }
// }

// class Solution {
//   public boolean isPowerOfThree(int n) {
//     //since: logb(n) = loge(n) / loge(b)
//     double log = Math.log(n) / Math.log(3);
//     return n < 0 ? false : Double.isFinite(log) && Math.pow(3, Math.round(log)) == n;
//   }
// }