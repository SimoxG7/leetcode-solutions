// import java.util.Arrays;

// class Solution {
//   public int findNumbers(int[] nums) {
//     return Arrays.stream(nums).filter(num -> Integer.toString(num).length() % 2 == 0).toArray().length;
//   }
// }

// class Solution {
//   public int findNumbers(int[] nums) {
//     return Arrays.stream(nums).filter(num -> (int)(Math.log10(num)+1) % 2 == 0).toArray().length;
//   }
// }

// class Solution {
//   public int findNumbers(int[] nums) {
//     int cont = 0;
//     for (int i = 0; i < nums.length; i++) {
//       if (Integer.toString(nums[i]).length() % 2 == 0) cont++;
//     }
//     return cont;
//   }
// }

class Solution {
  public int findNumbers(int[] nums) {
    int cont = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((int)(Math.log10(nums[i])+1) % 2 == 0) cont++;
    }
    return cont;
  }
}