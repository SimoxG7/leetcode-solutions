class Solution {
	public int binaryGap(int n) {
		int maxGaps = 0, currGaps = 0;
		boolean firstSetBitFound = false;
		while (n > 0) {
			boolean isSetBit = (n & 0x01) == 1;
			if (isSetBit) {
				if (firstSetBitFound) {
					maxGaps = Math.max(currGaps + 1, maxGaps);
					currGaps = 0;
				} else {
					firstSetBitFound = true;
				}
			} else if (firstSetBitFound) {
				currGaps++;
			}
			n >>= 1;
		}
		return maxGaps;
	}
}