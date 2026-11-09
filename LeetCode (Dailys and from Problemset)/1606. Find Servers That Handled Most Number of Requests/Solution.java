import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		TreeSet<Integer> available = new TreeSet<>();

		for (int i = 0; i < k; i++) {
			available.add(i);
		}

		PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

		int[] count = new int[k];
		int max = 0;

		for (int i = 0; i < arrival.length; i++) {
			while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
				int server = (int) busy.poll()[0];
				available.add(server);
			}

			if (available.isEmpty()) {
				continue;
			}

			int start = i % k;

			Integer server = available.ceiling(start);

			if (server == null) {
				server = available.first();
			}

			available.remove(server);

			count[server]++;
			max = Math.max(max, count[server]);

			long finishTime = (long) arrival[i] + load[i];
			busy.offer(new long[] { server, finishTime });
		}

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			if (count[i] == max) {
				res.add(i);
			}
		}

		return res;
	}
}