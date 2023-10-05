import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int minOcc = nums.length/3;
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    int cont = 1;
    int curr = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (curr == nums[i]) cont++;
      else {
        if (cont > minOcc) res.add(curr);
        curr = nums[i];
        cont = 1;
      }
    }
    if (cont > minOcc) res.add(curr);
    return res;
  }
}