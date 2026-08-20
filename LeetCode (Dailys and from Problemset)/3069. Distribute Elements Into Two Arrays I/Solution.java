class Solution {
	public int[] resultArray(int[] nums) {
		int n = nums.length;
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		arr1[0] = nums[0];
		arr2[0] = nums[1];

		int arr1LastIndex = 0, arr2LastIndex = 0;
		for (int i = 2; i < nums.length; i++) {
			if (arr1[arr1LastIndex] > arr2[arr2LastIndex]) arr1[++arr1LastIndex] = nums[i];
			else arr2[++arr2LastIndex] = nums[i];
		}

		for (int i = 0; i <= arr2LastIndex; i++) {
			arr1[++arr1LastIndex] = arr2[i];
		}

		return arr1;
	}
}