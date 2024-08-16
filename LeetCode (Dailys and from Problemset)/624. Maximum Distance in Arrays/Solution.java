import java.util.List;

class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
    int min = arrays.get(0).get(0);
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    int maxDistance = 0;

    for (int i = 1; i < arrays.size(); i++) {
      List<Integer> currentList = arrays.get(i);
      int currentMin = currentList.get(0);
      int currentMax = currentList.get(currentList.size() - 1);

      maxDistance = Math.max(maxDistance, Math.max(
          Math.abs(max - currentMin),
          Math.abs(currentMax - min)));

      min = Math.min(min, currentMin);
      max = Math.max(max, currentMax);
    }

    return maxDistance;
  }
}