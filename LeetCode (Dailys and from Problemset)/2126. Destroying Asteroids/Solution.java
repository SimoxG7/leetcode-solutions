import java.util.Arrays;

class Solution {
	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);
		long accumulatedMass = mass;
		for (int asteroid : asteroids) {
			if (accumulatedMass < asteroid) return false;
			accumulatedMass += asteroid;
		}
		return true;
	}
}