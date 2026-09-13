import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int largestOverlap(int[][] img1, int[][] img2) {
		int n = img1.length, ans = 0;
		List<int[]> pos1 = new ArrayList<>();
		List<int[]> pos2 = new ArrayList<>();

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (img1[r][c] == 1)
					pos1.add(new int[] { r, c });
				if (img2[r][c] == 1)
					pos2.add(new int[] { r, c });
			}
		}

		Map<String, Integer> mp = new HashMap<>();

		for (int[] p1 : pos1) {
			for (int[] p2 : pos2) {
				int dx = p2[0] - p1[0];
				int dy = p2[1] - p1[1];

				String key = dx + "," + dy;
				int count = mp.getOrDefault(key, 0) + 1;
				mp.put(key, count);

				ans = Math.max(ans, count);
			}
		}

		return ans;

	}
}