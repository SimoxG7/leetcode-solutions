
import java.util.Arrays;

class Solution {

	public int maximumSaleItems(int[][] items, int budget) {
		int n = items.length;
		int[] freq = new int[n + 1];
		int minCost = Integer.MAX_VALUE;
		for (int[] item : items) {
			minCost = Math.min(minCost, item[1]);
			freq[item[0]]++;
		}

		int[] gain = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (freq[i] == 0)
				continue;
			int cnt = 0;
			for (int j = i; j <= n; j += i) {
				cnt += freq[j];
			}
			gain[i] = cnt - 1;
		}

		Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
		int res = 0;

		for (int[] item : items) {
			int factor = item[0];
			int price = item[1];

			if (2 * minCost < price)
				continue;

			int buy = Math.min(gain[factor], budget / price);
			res += 2 * buy;
			budget -= buy * price;
		}

		return res + (budget / minCost);

	}
}