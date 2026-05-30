import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
	public List<Boolean> getResults(int[][] queries) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		List<Boolean> res = new ArrayList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(queries[a][1], queries[b][1]));
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			if (query[0] == 1) {
				priorityQueue.offer(i);
			} else {
				if (query[2] > query[1]) {
					res.add(false);
					continue;
				}
				while (!priorityQueue.isEmpty()) {
					insert(map, queries[priorityQueue.poll()]);
				}
				Map.Entry<Integer, Integer> curr = map.floorEntry(query[1]);
				if (isNull(curr) || Math.max(query[1] - curr.getKey(), curr.getValue()) >= query[2]) {
					res.add(true);
				} else {
					res.add(false);
				}
			}
		}
		return res;
	}

	public void insert(TreeMap<Integer, Integer> map, int[] query) {
		Map.Entry<Integer, Integer> prev = map.lowerEntry(query[1]);
		int value;
		if (nonNull(prev)) {
			map.put(query[1], Math.max(prev.getValue(), query[1] - prev.getKey()));
			value = Math.max(prev.getValue(), query[1] - prev.getKey());
		} else {
			map.put(query[1], query[1]);
			value = query[1];
		}
		Map.Entry<Integer, Integer> next = map.higherEntry(query[1]);
		int k = query[1];
		while (nonNull(next)) {
			if (next.getValue() == value) {
				break;
			}
			map.put(next.getKey(), Math.max(next.getKey() - k, value));
			value = Math.max(next.getKey() - k, value);
			k = next.getKey();
			next = map.higherEntry(k);
		}
	}
}