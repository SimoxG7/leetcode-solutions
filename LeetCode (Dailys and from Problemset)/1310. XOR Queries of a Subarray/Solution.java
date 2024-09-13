class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int[] preComputed = new int[n];
    preComputed[0] = arr[0];
    for (int i = 1; i < n; i++) {
      preComputed[i] = preComputed[i - 1] ^ arr[i];
    }
    int q = queries.length;
    int[] res = new int[q];
    for (int i = 0; i < q; i++) {
      int start = queries[i][0];
      int end = queries[i][1];
      if (start == 0) res[i] = preComputed[end];
      else res[i] = preComputed[start - 1] ^ preComputed[end];
    }
    return res;
  }
}

// O(N * Q)

// class Solution {
//   public int[] xorQueries(int[] arr, int[][] queries) {
//     int n = queries.length;
//     int[] res = new int[n];
//     for (int i = 0; i < n; i++) {
//       int start = queries[i][0];
//       int end = queries[i][1];
//       int curr = arr[start];
//       for (int j = start + 1; j <= end; j++) {
//         curr ^= arr[j];
//       }
//       res[i] = curr;
//     }
//     return res;
//   }
// }