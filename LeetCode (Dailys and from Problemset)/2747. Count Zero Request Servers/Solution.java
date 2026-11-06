import java.util.Arrays;

class Solution {
	public int[] countServers(int n, int[][] logs, int x, int[] queries) {
		int m = queries.length;

		Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

		int[][] q = new int[m][2];

		for (int i = 0; i < m; i++) {
			q[i][0] = queries[i];
			q[i][1] = i;
		}

		Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

		int[] freq = new int[n + 1];
		int[] res = new int[m];

		int left = 0, right = 0, activeServers = 0;

		for (int i = 0; i < m; i++) {
			int curr = q[i][0];
			int start = curr - x;

			while (right < logs.length && logs[right][1] <= curr) {
				int server = logs[right][0];

				if (freq[server] == 0) {
					activeServers++;
				}

				freq[server]++;
				right++;
			}

			while (left < right && logs[left][1] < start) {
				int server = logs[left][0];

				freq[server]--;

				if (freq[server] == 0) {
					activeServers--;
				}

				left++;
			}

			res[q[i][1]] = n - activeServers;
		}

		return res;
	}
}