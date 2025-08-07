class Solution {
  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    int n = baskets.length;
    int[] segmentTree = new int[4 * n];

    build(0, 0, n - 1, segmentTree, baskets);
    int unplaced = 0;
    for (int fruit : fruits) {
      if (checkUnplaced(0, 0, n - 1, segmentTree, fruit) == false)
        unplaced++;
    }
    return unplaced;
  }

  private void build(int i, int left, int right, int[] segmentTree, int[] baskets) {
    if (left == right) {
      segmentTree[i] = baskets[left];
      return;
    }
    int mid = (left + right) / 2;
    build(2 * i + 1, left, mid, segmentTree, baskets);
    build(2 * i + 2, mid + 1, right, segmentTree, baskets);

    segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
  }

  private boolean checkUnplaced(int i, int left, int right, int[] segmentTree, int fruit) {
    if (segmentTree[i] < fruit)
      return false;
    if (left == right) {
      segmentTree[i] = -1;
      return true;
    }
    int mid = (left + right) / 2;
    boolean placed = false;
    if (segmentTree[2 * i + 1] >= fruit)
      placed = checkUnplaced(2 * i + 1, left, mid, segmentTree, fruit);
    else
      placed = checkUnplaced(2 * i + 2, mid + 1, right, segmentTree, fruit);

    segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
    return placed;
  }
}