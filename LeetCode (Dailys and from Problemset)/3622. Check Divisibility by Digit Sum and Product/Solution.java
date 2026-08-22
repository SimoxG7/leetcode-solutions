class Solution {
	public boolean checkDivisibility(int n) {
		int sum = 0, product = 1;
		int original = n;

		while (n > 0) {
			int digit = n % 10;
			sum += digit;
			product *= digit;
			n /= 10;
		}

		return original % (sum + product) == 0;
	}
}

// class Solution {
// 	public boolean checkDivisibility(int n) {
// 		int[] digits = getDigitsArray(n);
// 		int sum = 0, product = 1;
// 		for (int digit : digits) {
// 			sum += digit;
// 			product *= digit;
// 		}

// 		return n % (sum + product) == 0;
// 	}

// 	private int[] getDigitsArray(int n) {
// 		int size;

// 		if (n < 10)
// 			size = 1;
// 		else if (n < 100)
// 			size = 2;
// 		else if (n < 1_000)
// 			size = 3;
// 		else if (n < 10_000)
// 			size = 4;
// 		else if (n < 100_000)
// 			size = 5;
// 		else if (n < 1_000_000)
// 			size = 6;
// 		else if (n < 10_000_000)
// 			size = 7;
// 		else if (n < 100_000_000)
// 			size = 8;
// 		else if (n < 1_000_000_000)
// 			size = 9;
// 		else
// 			size = 10;

// 		int[] digits = new int[size];
// 		for (int i = size - 1; i >= 0; i--) {
// 			digits[i] = n % 10;
// 			n /= 10;
// 		}

// 		return digits;
// 	}
// }