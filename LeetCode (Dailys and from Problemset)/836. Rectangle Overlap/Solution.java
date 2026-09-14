class Solution {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		int firstBottomLeftX = rec1[0], firstBottomLeftY = rec1[1], firstTopRightX = rec1[2], firstTopRightY = rec1[3];
		int secondBottomLeftX = rec2[0], secondBottomLeftY = rec2[1], secondTopRightX = rec2[2], secondTopRightY = rec2[3];

		// horizontal check
		if (firstBottomLeftX >= secondTopRightX || secondBottomLeftX >= firstTopRightX)
			return false;
		
		// vertical check
		return !(firstBottomLeftY >= secondTopRightY || secondBottomLeftY >= firstTopRightY);
	}
}