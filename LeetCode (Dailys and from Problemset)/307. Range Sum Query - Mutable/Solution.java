class NumArray {
  static class BinaryIndexedTree {
    int[] nums;
    int[] BIT;
    int n;

    public BinaryIndexedTree(int[] nums) {
      this.nums = nums;
      this.n = nums.length;
      BIT = new int[n + 1];
      for (int i = 0; i < n; i++) {
        init(i, nums[i]);
      }
    }

    void init(int i, int val) {
      i++;
      while (i <= n) {
        BIT[i] += val;
        i += (i & -i);
      }
    }

    void update(int i, int val) {
      int diff = val - nums[i];
      nums[i] = val;
      init(i, diff);
    }

    int getSum(int i) {
      i++;
      int ret = 0;
      while (i > 0) {
        ret += BIT[i];
        i -= (i & -i);
      }
      return ret;
    }
  }

  BinaryIndexedTree binaryIndexedTree;

  public NumArray(int[] nums) {
    binaryIndexedTree = new BinaryIndexedTree(nums);
  }

  public void update(int index, int val) {
    binaryIndexedTree.update(index, val);
  }

  public int sumRange(int left, int right) {
    return binaryIndexedTree.getSum(right) - binaryIndexedTree.getSum(left - 1);
  }
}

// class NumArray {

// private final int[] prefixSum;
// private final int n;

// public NumArray(int[] nums) {
// n = nums.length;
// prefixSum = new int[n];
// prefixSum[0] = nums[0];
// for (int i = 1; i < n; i++) {
// prefixSum[i] = prefixSum[i - 1] + nums[i];
// }
// }

// public void update(int index, int val) {
// int diff = val;
// if (index == 0) {
// diff -= prefixSum[index];
// } else {
// diff -= prefixSum[index] - prefixSum[index - 1];
// }
// for (int i = index; i < n; i++) {
// prefixSum[i] += diff;
// }
// }

// public int sumRange(int left, int right) {
// if (left == 0) return prefixSum[right];
// if (left == right) return prefixSum[right] - prefixSum[right - 1];
// return prefixSum[right] - prefixSum[left - 1];
// }
// }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */