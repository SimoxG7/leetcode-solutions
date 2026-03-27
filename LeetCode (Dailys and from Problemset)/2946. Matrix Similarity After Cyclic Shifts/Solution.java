class Solution {
  public boolean areSimilar(int[][] mat, int k) {
    int m = mat.length;
    int n = mat[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int ind = (j + k) % n;
        if (mat[i][j] != mat[i][ind]) {
          return false;
        }
      }
    }
    return true;
  }
}

// import java.util.Arrays;

// class Solution {
// public boolean areSimilar(int[][] mat, int k) {
// int m = mat.length, n = mat[0].length;
// int shifts = k % n;
// for (int i = 0; i < m; i++) {
// int[] row = mat[i];
// int[] copy = Arrays.copyOf(row, n);
// if (!Arrays.equals(row, shiftArray(i % 2 == 0, copy, shifts)))
// return false;
// }
// return true;
// }

// private int[] shiftArray(boolean directionIsLeft, int[] arr, int shiftOffset)
// {
// if (directionIsLeft) shiftLeft(arr, shiftOffset);
// else shiftRight(arr, shiftOffset);
// return arr;
// }

// public void shiftRight(int[] arr, int n) {
// int len = arr.length;
// n %= len;
// int[] temp = new int[n];

// // copy the tail that will wrap around to temp
// System.arraycopy(arr, len - n, temp, 0, n);
// // shift the front part to the end
// System.arraycopy(arr, 0, arr, n, len - n);
// // put temp back at the start
// System.arraycopy(temp, 0, arr, 0, n);
// }

// public void shiftLeft(int[] arr, int n) {
// int len = arr.length;
// n %= len;
// int[] temp = new int[n];

// // copy the head that will wrap around to temp
// System.arraycopy(arr, 0, temp, 0, n);
// // shift the back part to the front
// System.arraycopy(arr, n, arr, 0, len - n);
// // put temp back at the end
// System.arraycopy(temp, 0, arr, len - n, n);
// }
// }