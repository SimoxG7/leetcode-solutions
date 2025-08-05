class Solution {
  public int numOfUnplacedFruits(int[] fruitSizes, int[] basketCapacities) {
    int totalFruits = fruitSizes.length;
    int unplacedFruits = totalFruits;

    for (int i = 0; i < totalFruits; i++) {
      for (int j = 0; j < totalFruits; j++) {
        if (fruitSizes[i] <= basketCapacities[j]) {
          basketCapacities[j] = 0;
          unplacedFruits--;
          break;
        }
      }
    }

    return unplacedFruits;
  }
}