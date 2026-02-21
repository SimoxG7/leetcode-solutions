import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

	private static final Set<Integer> primesUnder32 = new HashSet<>(Arrays.asList(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19})); //stopping here because it's 10^6 max

	public int countPrimeSetBits(int left, int right) {
		int count = 0;
		for (int i = left; i <= right; i++) {
			if (hasPrimeSetBits(i)) count++;
		}
		return count;
	}

	// private int countSetBits(int num) {
	// 	int count = 0;
	// 	while (num > 0) {
	// 		count += num & 0x01;
	// 		num >>= 1;
	// 	}
	// 	return count;
	// }

	private int countSetBits(int i) { //code from Integer.bitCount(), very curious code
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}

	private boolean hasPrimeSetBits(int num) {
		return primesUnder32.contains(countSetBits(num));
	}
}