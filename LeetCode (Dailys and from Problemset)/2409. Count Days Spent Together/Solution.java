class Solution {

	// private static final int[] daysPerMonth0Index = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] daysPrefixSum = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
		int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
		int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
		int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));

		if (aliceLeaveMonth < bobArriveMonth || bobLeaveMonth < aliceArriveMonth)
			return 0;

		int aliceArriveDay = Integer.parseInt(arriveAlice.substring(3));
		int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3));
		int bobArriveDay = Integer.parseInt(arriveBob.substring(3));
		int bobLeaveDay = Integer.parseInt(leaveBob.substring(3));

		int exactMaximumArriveDay = Math.max(
			daysPrefixSum[aliceArriveMonth - 1] + aliceArriveDay,
			daysPrefixSum[bobArriveMonth - 1] + bobArriveDay
		);

		int exactMinimumLeaveDay = Math.min(
			daysPrefixSum[aliceLeaveMonth - 1] + aliceLeaveDay,
			daysPrefixSum[bobLeaveMonth - 1] + bobLeaveDay
		);

		return Math.max(0, exactMinimumLeaveDay - exactMaximumArriveDay + 1);
	}
}