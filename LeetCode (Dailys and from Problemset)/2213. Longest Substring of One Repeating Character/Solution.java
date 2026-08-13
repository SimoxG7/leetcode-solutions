
class Solution {
  int[] len, prefix, suffix, maxRun;
  char[] firstChar, lastChar, strCharArray;

  void build(int node, int left, int right) {
    if (left == right) {
      len[node] = prefix[node] = suffix[node] = maxRun[node] = 1;
      firstChar[node] = lastChar[node] = strCharArray[left];
      return;
    }
    int mid = (left + right) >> 1;
    build(node << 1, left, mid);
    build(node << 1 | 1, mid + 1, right);
    merge(node);
  }

  void merge(int node) {
    int leftNode = node << 1, rightNode = leftNode | 1;
    len[node] = len[leftNode] + len[rightNode];
    firstChar[node] = firstChar[leftNode];
    lastChar[node] = lastChar[rightNode];
    prefix[node] = prefix[leftNode];
    suffix[node] = suffix[rightNode];
    maxRun[node] = Math.max(maxRun[leftNode], maxRun[rightNode]);

    if (lastChar[leftNode] == firstChar[rightNode]) {
      maxRun[node] = Math.max(maxRun[node], suffix[leftNode] + prefix[rightNode]);
      if (prefix[leftNode] == len[leftNode])
        prefix[node] = len[leftNode] + prefix[rightNode];
      if (suffix[rightNode] == len[rightNode])
        suffix[node] = len[rightNode] + suffix[leftNode];
    }
  }

  void update(int node, int left, int right, int index) {
    if (left == right) {
      firstChar[node] = lastChar[node] = strCharArray[index];
      return;
    }
    int mid = (left + right) >> 1;
    if (index <= mid)
      update(node << 1, left, mid, index);
    else
      update(node << 1 | 1, mid + 1, right, index);
    merge(node);
  }

  public int[] longestRepeating(String str, String queryCharacters, int[] queryIndices) {
    strCharArray = str.toCharArray();
    int n = strCharArray.length;
    len = new int[4 * n];
    prefix = new int[4 * n];
    suffix = new int[4 * n];
    maxRun = new int[4 * n];
    firstChar = new char[4 * n];
    lastChar = new char[4 * n];

    build(1, 0, n - 1);
    int[] result = new int[queryIndices.length];

    for (int i = 0; i < queryIndices.length; i++) {
      int index = queryIndices[i];
      strCharArray[index] = queryCharacters.charAt(i);
      update(1, 0, n - 1, index);
      result[i] = maxRun[1];
    }
    return result;
  }
}