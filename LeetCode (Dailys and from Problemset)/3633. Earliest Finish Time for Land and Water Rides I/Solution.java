class Solution {
	public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
		int bestLandFinish = Integer.MAX_VALUE;
		for (int i = 0; i < landStartTime.length; i++) {
			bestLandFinish = Math.min(bestLandFinish, landStartTime[i] + landDuration[i]);
		}
		int landThenWater = Integer.MAX_VALUE;
		for (int j = 0; j < waterStartTime.length; j++) {
			landThenWater = Math.min(landThenWater, Math.max(bestLandFinish, waterStartTime[j]) + waterDuration[j]);
		}

		int bestWaterFinish = Integer.MAX_VALUE;
		for (int j = 0; j < waterStartTime.length; j++) {
			bestWaterFinish = Math.min(bestWaterFinish, waterStartTime[j] + waterDuration[j]);
		}
		int waterThenLand = Integer.MAX_VALUE;
		for (int i = 0; i < landStartTime.length; i++) {
			waterThenLand = Math.min(waterThenLand, Math.max(bestWaterFinish, landStartTime[i]) + landDuration[i]);
		}

		return Math.min(landThenWater, waterThenLand);
	}
}