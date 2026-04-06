class Solution {
	public boolean judgeCircle(String moves) {
		int horizontalPosition = 0, verticalPosition = 0;
		final char LEFT = 'L', RIGHT = 'R', UP = 'U', DOWN = 'D';
		for (char move : moves.toCharArray()) {
			switch (move) {
				case LEFT -> horizontalPosition--;
				case RIGHT -> horizontalPosition++;
				case UP -> verticalPosition++;
				case DOWN -> verticalPosition--;
			}
		}
		return horizontalPosition == 0 && verticalPosition == 0;
	}
}