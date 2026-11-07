import java.util.PriorityQueue;

class Solution {

	public int[] assignTasks(int[] servers, int[] tasks) {
		int n = servers.length, m = tasks.length;
		PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [freeTime, idx]
		PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> { // [weight, idx]
			if (a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});

		for (int i = 0; i < n; i++) {
			freeServers.offer(new int[] { servers[i], i });
		}

		int time = 0;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			time = Math.max(time, i);

			// cleanup busy servers that went free
			while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
				int[] server = busyServers.poll();
				int idx = server[1];
				freeServers.offer(new int[] { servers[idx], idx });
			}

			if (freeServers.isEmpty()) { // wait for busy to finish and set them to free
				time = busyServers.peek()[0];
				while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
					int[] server = busyServers.poll();
					int idx = server[1];
					freeServers.offer(new int[] { servers[idx], idx });
				}
			}

			int[] server = freeServers.poll();
			int idx = server[1];
			res[i] = idx;
			busyServers.offer(new int[] { time + tasks[i], idx });
		}

		return res;
	}
}