class Solution {
  public String[] createGrid(int m, int n) {
    String[] result = new String[m];

    String rowString = "." + "#".repeat(n - 1);
    for (int i = 0; i < m - 1; i++) {
      result[i] = rowString;
    }
    result[m - 1] = ".".repeat(n);

    return result;
  }
}