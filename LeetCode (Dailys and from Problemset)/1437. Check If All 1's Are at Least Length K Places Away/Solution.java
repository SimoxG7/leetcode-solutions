class Solution {
	public boolean kLengthApart(int[] nums, int k) {
		int prevOneIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (prevOneIndex != -1 && i - prevOneIndex - 1 < k) {
					return false;
				}
				prevOneIndex = i;
			}
		}
		return true;
	}
}