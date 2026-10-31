
import static java.util.Objects.isNull;

class Solution {

	int[][][] dp;
	int modulo = 1_000_000_007;

	private enum Direction {
		DOWN,
		RIGHT,
		INITIAL
	}

	private int recursion(int row, int col, Direction direction, int[][] grid) {

		int directionAsInt;

		if (isNull(direction))
			directionAsInt = 2;
		else
			directionAsInt = switch (direction) {
				case INITIAL -> 0;
				case RIGHT -> 1;
				default -> 2;
			};

		// oob
		if (row < 0 || col < 0 ||
				row >= grid.length || col >= grid[0].length)
			return 0;

		// reached
		if (row == grid.length - 1 &&
				col == grid[0].length - 1)
			return 1;

		// precalculated
		if (dp[row][col][directionAsInt] != -1)
			return dp[row][col][directionAsInt];

		int right = 0, down = 0;

		// mirror
		if (grid[row][col] == 1) {

			if (direction == Direction.DOWN) {
				right = recursion(row, col + 1, Direction.RIGHT, grid);
			} else if (direction == Direction.RIGHT) {
				down = recursion(row + 1, col, Direction.DOWN, grid);
			}

		} else {

			// empty
			right = recursion(row, col + 1, Direction.RIGHT, grid);
			down = recursion(row + 1, col, Direction.DOWN, grid);

		}

		dp[row][col][directionAsInt] = (right + down) % modulo;

		return dp[row][col][directionAsInt];
	}

	public int uniquePaths(int[][] grid) {

		dp = new int[grid.length][grid[0].length][3];

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {

				dp[i][j][0] = -1; // initial
				dp[i][j][1] = -1; // right
				dp[i][j][2] = -1; // down

			}
		}

		return recursion(0, 0, Direction.INITIAL, grid);
	}
}