class Solution {
  public int minSteps(int n) {
    int operationCounter = 0;
    int currentSize = 1;
    int toAdd = 0;
    while (currentSize != n) {
      if (n % currentSize == 0) {
        toAdd = currentSize;
        operationCounter++;
      }
      currentSize += toAdd;
      operationCounter++;
    }
    return operationCounter;
  }
}