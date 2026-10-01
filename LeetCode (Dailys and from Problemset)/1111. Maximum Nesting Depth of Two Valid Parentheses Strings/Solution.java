class Solution {

  public int[] maxDepthAfterSplit(String seq) {
    int n = seq.length();
    int[] acc = new int[n];

    int open = 0;
    int i = 0;

    for (char c : seq.toCharArray()) {
      if (c == '(') {
        open++;
        acc[i] = open % 2;
      } else {
        acc[i] = open % 2;
        open--;
      }

      i++;
    }

    return acc;
  }
}