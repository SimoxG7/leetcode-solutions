public class Solution {
  public int eliminateMaximum(int[] dist, int[] speed) {
    int n = dist.length;
    for (int i = 0; i < n; i++) {
      dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
      speed[i] = 0;
    }
    for (int num : dist) {
      if (num >= n)
        continue;
      speed[num]++;
    }
    for (int i = 1; i < n; i++) {
      speed[i] += speed[i - 1];
      if (speed[i] > i) {
        return i;
      }
    }
    return n;
  }
}