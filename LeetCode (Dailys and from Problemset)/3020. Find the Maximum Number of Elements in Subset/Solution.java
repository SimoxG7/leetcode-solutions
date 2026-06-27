import java.util.HashMap;
import java.util.Map;

class Solution {
	public static int maximumLength(int[] nums) {
		Map<Long, Integer> freq = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (int num : nums) {
			freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
		}

		if (freq.containsKey(1L)) {
			int ones = freq.get(1L);
			max = Math.max(max, ones % 2 == 0 ? ones - 1 : ones);
		}

		for (long key : freq.keySet()) {
			int len = 0;
			if (key == 1L)
				continue;
			else {
				long next = key;
				while (freq.containsKey(next)) {
					if (freq.get(next) >= 2)
						len++;
					else {
						len++;
						break;
					}
					next *= next;
				}
				max = Math.max(max, (2 * len) - 1);
			}
		}

		return max;
	}
}