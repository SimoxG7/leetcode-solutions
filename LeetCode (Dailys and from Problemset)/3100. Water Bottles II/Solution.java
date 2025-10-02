class Solution {
  public int maxBottlesDrunk(int numBottles, int numExchange) {
    int drunkBottles = numBottles, emptyBottles = numBottles;
    while (emptyBottles >= numExchange) {
      drunkBottles++;
      emptyBottles = emptyBottles - numExchange++ + 1;
    }
    return drunkBottles;
  }
}