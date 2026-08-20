class Solution {
	public int[] resultArray(int[] nums) {
		int n = nums.length;
		int[] arr2 = new int[n];
		arr2[0] = nums[1];

		int arr1LastIndex = 0, arr2LastIndex = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[arr1LastIndex] > arr2[arr2LastIndex]) nums[++arr1LastIndex] = nums[i];
			else arr2[++arr2LastIndex] = nums[i];
		}

		for (int i = 0; i <= arr2LastIndex; i++) {
			nums[++arr1LastIndex] = arr2[i];
		}

		return nums;
	}
}