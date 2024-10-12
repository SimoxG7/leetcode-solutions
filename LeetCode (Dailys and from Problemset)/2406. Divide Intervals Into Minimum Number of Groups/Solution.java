class Solution {

  int[] bit;
  int N;

  int sum(int id) {
    int ans = 0;
    while (id > 0) {
      ans += bit[id];
      id = (id - (id & -id));
    }
    return ans;
  }

  void update(int id, int x) {

    while (id <= N) {
      bit[id] += x;
      id = (id + (id & -id));
    }
  }

  void updateRange(int l, int r) {
    update(l, 1);
    update(r + 1, -1);
  }

  public int minGroups(int[][] a) {

    for (int i = 0; i < a.length; i++) {
      N = Math.max(N, a[i][1]);
    }
    bit = new int[N + 2];

    for (int i = 0; i < a.length; i++) {
      updateRange(a[i][0], a[i][1]);
    }

    int ans = 0;
    for (int i = 1; i < bit.length; i++) {
      ans = Math.max(ans, sum(i));
    }

    return ans;
  }
}