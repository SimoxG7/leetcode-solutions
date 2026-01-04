class Solution {
  public int sumFourDivisors(int[] nums) {
    int totalsum = 0;
    for (int num : nums) {
      int count = 0;
      int sum = 0;
      for (int i = 1; i * i <= num; i++) {
        if (num % i == 0) {
          count++;
          sum += i;
          if (i != num / i) {
            count++;
            sum += num / i;
          }
          if (count > 4) {
            break;
          }
        }
      }
      if (count == 4) {
        totalsum += sum;
      }
    }
    return totalsum;
  }
}

// class Solution {
// public int sumFourDivisors(int[] nums) {
// int sum = 0;
// for (int num : nums) {
// int divisors = 2; // 1, num
// int divisorsSum = 1 + num;
// for (int i = 2; i < num / 2 + 1; i++) {
// if (num % i == 0) {
// divisors++;
// divisorsSum += i;
// if (divisors > 4) break;
// }
// }
// if (divisors == 4)
// sum += divisorsSum;
// }
// return sum;
// }
// }
