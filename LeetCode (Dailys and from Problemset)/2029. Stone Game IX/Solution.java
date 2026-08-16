class Solution {
  public boolean stoneGameIX(int[] stones) {
    int[] modCount = new int[3];
    for (int i = 0; i < stones.length; i++) {
      modCount[stones[i] % 3]++;
    }

    modCount[0] %= 2;
    
    if (modCount[0] == 0) return modCount[1] >= 1 && modCount[2] >= 1;
    return Math.abs(modCount[1] - modCount[2]) > 2;
  }
}