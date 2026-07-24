import java.util.HashSet;
import java.util.Set;

class Solution {
  public int uniqueXorTriplets(int[] nums) {

    Set<Integer> uniqueValues = new HashSet<>();

    for (int num : nums) {
      uniqueValues.add(num);
    }

    final int MAX_XOR = 2048;

    boolean[] reachablePairXor = new boolean[MAX_XOR];
    boolean[] reachableTripletXor = new boolean[MAX_XOR];

    for (int first : uniqueValues) {
      for (int second : uniqueValues)
        reachablePairXor[first ^ second] = true;
    }

    for (int xorValue = 0; xorValue < MAX_XOR; xorValue++) {
      if (!reachablePairXor[xorValue])
        continue;
      for (int third : uniqueValues)
        reachableTripletXor[xorValue ^ third] = true;
    }

    int uniqueTriplets = 0;
    for (boolean reachable : reachableTripletXor) {
      if (reachable)
        uniqueTriplets++;
    }
    return uniqueTriplets;
  }
}