class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int left = 0;
    int right = arr.length-1;
    while (left <= right) {
      int mid = right - (right - left)/2;
      System.out.println(mid);
      if (mid + 1 >= arr.length) return mid - 1;
      if (arr[mid] < arr[mid+1]) left = mid+1;
      else right = mid-1;
    }
    return left;
  }
}