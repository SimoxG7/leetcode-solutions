class Solution {
  public String triangleType(int[] nums) {
    int equalCount = 0;
    equalCount += nums[0] == nums[1] ? 1 : 0;
    equalCount += nums[0] == nums[2] ? 1 : 0;
    equalCount += nums[1] == nums[2] ? 1 : 0;
    if (equalCount == 3) return "equilateral";
    else if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) return "none";
    else if (equalCount == 1) return "isosceles";
    else return "scalene";
  }
}