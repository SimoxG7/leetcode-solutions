class Solution {
  public int maxDistance(String s, int k) {
    int S = 0, W = 0, N = 0, E = 0;
    int maxManhattan = 0;
    for (char c : s.toCharArray()) {
      switch (c) {
        case 'S':
          S++;
          break;
        case 'W':
          W++;
          break;
        case 'N':
          N++;
          break;
        case 'E':
          E++;
          break;
      }
      int minNS = Math.min(N, S);
      int consumedNS = Math.min(minNS, k);
      
      int minEW = Math.min(W, E);
      int consumedEW = Math.min(minEW, k - consumedNS);

      maxManhattan = Math.max(maxManhattan, Math.abs(N - S) + consumedNS * 2 + Math.abs(E - W) + consumedEW * 2);
    }
    return maxManhattan;
  }
}