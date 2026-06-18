class Solution {

	static final int DEGREES_PER_MINUTE = 6; // 360 / 60
	static final int DEGREES_PER_HOUR = 30; // 360 / 12
	static final int HOURS_PER_CLOCK = 12;
	static final int MINUTES_PER_HOUR = 60;
	static final int DEGREES_PER_CLOCK = 360;

	public double angleClock(int hour, int minutes) {
		// don't want to work with 12:30, I am not fucking American
		// this also handles European times btw
		hour = hour % HOURS_PER_CLOCK;

		int minutesDegrees = minutes * DEGREES_PER_MINUTE;
		double hourDegrees = hour * DEGREES_PER_HOUR + (DEGREES_PER_HOUR / ((double) MINUTES_PER_HOUR / minutes));
		double diff = Math.abs(hourDegrees - minutesDegrees);
		return Math.min(diff, DEGREES_PER_CLOCK - diff);
	}
}