class Solution {
  public boolean primeSubOperation(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (checkSort(nums)) {
        return true;
      }
      int n = (i == 0) ? nums[0] : nums[i] - nums[i - 1];
      if (n <= 0) {
        return false;
      }
      nums[i] -= getLessPrime(n);
    }
    return checkSort(nums);
  }

  boolean checkSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] >= nums[i + 1]) {
        return false;
      }
    }
    return true;
  }

  int getLessPrime(int n) {
    n--;
    while (n > 1 && !isPrime(n)) {
      n--;
    }
    return n > 1 ? n : 0;
  }

  boolean isPrime(int n) {
    if (n <= 1)
      return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// class Solution {
// public boolean primeSubOperation(int[] nums) {
// int n = nums.length;
// if (isSortedStrictly(nums)) return true;
// int max = findMax(nums);
// int[] primes = findPrimes(max);
// for (int i = 0; i < nums.length; i++) {

// }
// }

// private boolean isSortedStrictly(int[] nums) {
// for (int i = 0; i < nums.length - 1; i++) {
// if (nums[i] >= nums[i + 1])
// return false;
// }
// return true;
// }

// private int findMax(int[] nums) {
// int max = nums[0];
// for (int i = 1; i < nums.length; i++) {
// max = Math.max(max, nums[i]);
// }
// return max;
// }

// private int[] findPrimes(int upperBound) {
// return atkinSieve(upperBound).stream().mapToInt(i -> i).toArray();
// }

// private List<Integer> atkinSieve(int limit) {
// boolean[] sieve = new boolean[limit + 1];

// // result List
// List<Integer> primes = new ArrayList<>();
// primes.addAll(List.of(2, 3, 5));

// // set of wheel "hit" positions for a 2/3/5 wheel rolled twice as per the
// Atkin algorithm
// int[] s = { 1, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 49, 53, 59 };

// Integer[] firstGroup = { 1, 13, 17, 29, 37, 41, 49, 53 };
// Set<Integer> firstSet = new HashSet<>();
// firstSet.addAll(Arrays.asList(firstGroup));

// Integer[] secondGroup = { 7, 19, 31, 43 };
// Set<Integer> secondSet = new HashSet<>();
// secondSet.addAll(Arrays.asList(secondGroup));

// Integer[] thirdGroup = { 11, 23, 47, 59 };
// Set<Integer> thirdSet = new HashSet<>();
// thirdSet.addAll(Arrays.asList(thirdGroup));

// // THIS IS SKIPPED CAUSE IT SHOULD ALL BE FALSE ALREADY!
// // Initialize the sieve with enough wheels to include limit:
// // for (int w = 0; w < upperBound / 60; w++) {
// // for (int x : s) {
// // sieve[60 * w + x] = false;
// // }
// // }

// // Put in candidate primes:
// // integers which have an odd number of
// // representations by certain quadratic forms.
// for (int x = 1; x <= limit; x++) { //all x
// for (int y = 1; y <= limit; y += 2) { //odd y
// int n = 4 * x * x + y * y;
// if (n <= limit && firstSet.contains(n % 60)) sieve[n] = !sieve[n]; //toggle
// state
// }
// }

// for (int x = 1; x <= limit; x += 2) { //odd x
// for (int y = 2; y <= limit; y += 2) { //even y
// int n = 3 * x * x + y * y;
// if (n <= limit && secondSet.contains(n % 60)) sieve[n] = !sieve[n]; //toggle
// state
// }
// }

// for (int x = 2; x <= limit; x++) { //all even/odd
// for (int y = x - 1; y >= 1; y -= 2) { //odd/even combos
// int n = 3 * x * x - y * y;
// if (n <= limit && thirdSet.contains(n % 60)) sieve[n] = !sieve[n]; //toggle
// state
// }
// }

// // Eliminate composites by sieving, only for those occurrences on the wheel:
// for (int w = 0; w <= limit; w++) {
// for (int x : s) {
// int n = 60 * w + x;
// int nSquared = n * n;
// // n is prime, omit multiples of its square; this is sufficient
// // because square-free composites can't get on this list
// if (n >= 7 && nSquared <= limit && sieve[n]) {
// int c = nSquared * (60 * w + x);
// sieve[c] = false;
// }
// }
// }

// // one sweep to produce a sequential list of primes up to limit:
// for (int w = 0; w <= limit; w++) {
// for (int x : s) {
// int n = 60 * w + x;
// if (n >= 7 && n <= limit && sieve[n]) primes.add(n);
// }
// }

// return primes;
// }

// }