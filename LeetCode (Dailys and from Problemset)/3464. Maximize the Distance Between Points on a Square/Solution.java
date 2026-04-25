import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	int n;
	List<Long> rolledPoints;
	long perimeter;

	private int lowerBound(long num) {
		int low = 0;
		int high = 2 * n - 1;
		int res = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (rolledPoints.get(mid) >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return res;
	}

	private boolean notValid(long limit, int k) {
		for (int i = 0; i < n; i++) {
			int count = 1;
			int currPoint = i;

			while (count < k) {
				long nextPoint = rolledPoints.get(currPoint) + limit;
				int nextPointIdx = lowerBound(nextPoint);

				if (nextPointIdx == -1)
					break;

				++count;
				currPoint = nextPointIdx;

				if (rolledPoints.get(currPoint) - rolledPoints.get(i) > perimeter - limit) {
					count = 0;
					break;
				}
			}

			if (count == k)
				return false;
		}

		return true;
	}

	public int maxDistance(int side, int[][] points, int k) {
		n = points.length;

		perimeter = 4L * side;

		rolledPoints = new ArrayList<>();

		for (int[] point : points) {
			int x = point[0];
			int y = point[1];

			if (y == 0)
				rolledPoints.add(x * 1L);
			else if (x == side)
				rolledPoints.add(1L * side + 1L * y);
			else if (y == side)
				rolledPoints.add(3L * side - 1L * x);
			else
				rolledPoints.add(4L * side - 1L * y);
		}

		Collections.sort(rolledPoints);

		for (int i = 0; i < n; i++) {
			rolledPoints.add(rolledPoints.get(i) + perimeter);
		}

		long low = 0;
		long high = perimeter;

		long ans = -1;

		while (low <= high) {
			long mid = low + (high - low) / 2L;

			if (!notValid(mid, k)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return (int) ans;
	}
}