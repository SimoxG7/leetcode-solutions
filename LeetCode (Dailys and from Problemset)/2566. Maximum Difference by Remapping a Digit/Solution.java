class Solution {
  public int minMaxDifference(int num) {
    int maxSub = 9, minSub = 0;
    String numString = String.valueOf(num);
    for (char c : numString.toCharArray()) {
      if (maxSub == 9 && c != '9') maxSub = c - '0';
      if (minSub == 0 && c != '0') minSub = c - '0';
    }
    int numStringMax = Integer.parseInt(numString.replaceAll(String.valueOf(maxSub), "9"));
    int numStringMin = Integer.parseInt(numString.replaceAll(String.valueOf(minSub), "0"));
    return numStringMax - numStringMin;
  }
}

// class Solution {
//   public int minMaxDifference(int num) {
//     String numString = "" + num;
//     char toSwitchForMax = 0, toSwitchForMin = 0;
//     for (char c : numString.toCharArray()) {
//       if (c != '9') {
//         toSwitchForMax = c;
//         break;
//       }
//     }
//     for (char c : numString.toCharArray()) {
//       if (c != '0') {
//         toSwitchForMin = c;
//         break;
//       }
//     }
//     int numStringMax = Integer.parseInt(numString.replaceAll(toSwitchForMax + "", "9"));
//     int numStringMin = Integer.parseInt(numString.replaceAll(toSwitchForMin + "", "0"));
//     return numStringMax - numStringMin;
//   }
// }