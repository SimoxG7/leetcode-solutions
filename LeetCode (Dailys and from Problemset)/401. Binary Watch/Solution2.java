import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    int[] bitsForDigits = countActivatedBitsDP(60);
    List<String> res = new ArrayList<>();
    for (int hours = 0; hours < 12; hours++) {
      for (int minutes = 0; minutes < 60; minutes++) {
        // if (Integer.bitCount(hours) + Integer.bitCount(minutes) == turnedOn) res.add(String.format("%d:%02d", hours, minutes));
        if (bitsForDigits[hours] + bitsForDigits[minutes] == turnedOn) res.add(String.format("%d:%02d", hours, minutes));
      }
    }
    return res;
  }

  private int[] countActivatedBitsDP(int upperBound) {
    int[] dp = new int[upperBound];
    for (int i = 1; i < upperBound; i++) {
      dp[i] = dp[i >> 1] + (i & 1);
    }
    return dp;
  }

  // private int countOnBits(int num) {
  //   int onBits = 0;
  //   while (num > 0) {
  //     onBits += (num & 0b1);
  //     num >>= 1;
  //   }
  //   return onBits;
  // }
}