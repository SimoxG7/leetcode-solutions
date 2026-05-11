import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] rotateGrid(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		int layers = Math.min(m, n) / 2;

		for (int i = 0; i < layers; i++) {
			int top = i, left = i;
			int bottom = m - 1 - i, right = n - 1 - i;

			List<Integer> layerElements = new ArrayList<>();

			// Top row (left to right)
			for (int j = left; j < right; j++)
				layerElements.add(grid[top][j]);
			// Right col (top to bottom)
			for (int j = top; j < bottom; j++)
				layerElements.add(grid[j][right]);
			// Bottom row (right to left)
			for (int j = right; j > left; j--)
				layerElements.add(grid[bottom][j]);
			// Left col (bottom to top)
			for (int j = bottom; j > top; j--)
				layerElements.add(grid[j][left]);

			int totalElements = layerElements.size();
			int netRotation = k % totalElements;

			int index = netRotation;

			for (int j = left; j < right; j++) {
				grid[top][j] = layerElements.get(index % totalElements);
				index++;
			}
			for (int j = top; j < bottom; j++) {
				grid[j][right] = layerElements.get(index % totalElements);
				index++;
			}
			for (int j = right; j > left; j--) {
				grid[bottom][j] = layerElements.get(index % totalElements);
				index++;
			}
			for (int j = bottom; j > top; j--) {
				grid[j][left] = layerElements.get(index % totalElements);
				index++;
			}
		}
		return grid;
	}
}