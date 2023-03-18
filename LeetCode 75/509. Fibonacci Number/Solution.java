// class Solution {
//   public int fib(int n) {
//     if (n <= 0) return 0;
//     else if (n <= 2) return 1;
//     else return fib(n-1) + fib(n-2);
//   }
// }


//this runs much better (0ms, 100%)
class Solution {
  public int fib(int n) {
    if (n == 1) return 1;
    int first = 0, second = 1, next = 0;
    for (int i = 0; i < n-1; i++) {
      next = first + second;
      first = second;
      second = next;
    }
    return next;
  }
}