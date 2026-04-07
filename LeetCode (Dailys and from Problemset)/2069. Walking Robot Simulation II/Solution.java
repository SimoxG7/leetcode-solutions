class Robot {

	private final int width;
	private final int height;
	private final int perimeter;
	private final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private final String[] directionLabels = { "East", "North", "West", "South" };

	private int x;
	private int y;
	private int directionIndex;

	public Robot(int width, int height) {
		this.width = width;
		this.height = height;
		this.perimeter = (this.width + this.height - 2) * 2;
		this.x = 0;
		this.y = 0;
		this.directionIndex = 0;
	}

	public void step(int num) {
		System.out.println(String.format("Stepping for %d from (%d, %d). Direction is %s", num, x, y, directionLabels[directionIndex]));
		num %= perimeter;

		//did a full circle and needs to change direction (as num cannot be less than 1)
		if (num == 0 && (x == 0 && y == 0)) directionIndex = 3;

		while (num > 0) {
			int dx = directions[directionIndex][0];
			int dy = directions[directionIndex][1];

			int maxSteps = 0;
			if (dx == 1) maxSteps = (width - 1) - x;
			if (dx == -1) maxSteps = x;
			if (dy == 1) maxSteps = (height - 1) - y;
			if (dy == -1) maxSteps = y;

			int actualSteps = Math.min(num, maxSteps);
			x += dx * actualSteps;
			y += dy * actualSteps;
			num -= actualSteps;

			if (num > 0) directionIndex = (directionIndex + 1) % 4;
		}
	}

	public int[] getPos() {
		return new int[] { x, y };
	}

	public String getDir() {
		return directionLabels[directionIndex];
	}
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */