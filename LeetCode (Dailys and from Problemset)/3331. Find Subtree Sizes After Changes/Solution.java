import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int[] findSubtreeSizes(int[] parent, String s) {
		int n = parent.length;
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 1; i < n; i++)
			graph[parent[i]].add(i);
		int[] size = new int[n];
		int[] last = new int[26];
		Arrays.fill(last, -1);
		dfs(0, -1, graph, s, last, size);
		return size;
	}

	private void dfs(int node, int parent, List<Integer>[] graph, String s, int[] last, int[] size) {
		size[node] = 1;
		int lastPosi = last[s.charAt(node) - 'a'];
		last[s.charAt(node) - 'a'] = node;
		for (int next : graph[node]) {
			dfs(next, node, graph, s, last, size);
		}
		last[s.charAt(node) - 'a'] = lastPosi;
		if (lastPosi != -1) {
			size[lastPosi] += size[node];
		} else if (parent != -1) {
			size[parent] += size[node];
		}
	}
}