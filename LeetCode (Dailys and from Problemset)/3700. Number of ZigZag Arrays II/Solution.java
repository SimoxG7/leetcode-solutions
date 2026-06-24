class Solution {
  static final int MOD = 1000000007;

  public int zigZagArrays(int n, int l, int r) {
    int rangeSize = r - l + 1;

    long[] initialCounts = new long[rangeSize];
    for (int i = 0; i < rangeSize; i++)
      initialCounts[i] = i;

    long[][] transitionMatrix = new long[rangeSize][rangeSize];
    for (int currentVal = 1; currentVal < rangeSize; currentVal++)
      for (int prevVal = rangeSize - currentVal; prevVal < rangeSize; prevVal++)
        transitionMatrix[currentVal][prevVal] = 1;

    long[][] transitionMatrixPow = matrixPow(transitionMatrix, n - 2, rangeSize);

    long answer = 0;
    for (int i = 0; i < rangeSize; i++)
      for (int j = 0; j < rangeSize; j++)
        answer = (answer + transitionMatrixPow[i][j] * initialCounts[j]) % MOD;

    return (int) (answer * 2 % MOD);
  }

  long[][] matrixMul(long[][] matrixA, long[][] matrixB, int size) {
    long[][] result = new long[size][size];
    for (int row = 0; row < size; row++)
      for (int mid = 0; mid < size; mid++) {
        if (matrixA[row][mid] == 0)
          continue;
        for (int col = 0; col < size; col++)
          result[row][col] = (result[row][col] + matrixA[row][mid] * matrixB[mid][col]) % MOD;
      }
    return result;
  }

  long[][] matrixPow(long[][] matrix, int power, int size) {
    long[][] result = new long[size][size];
    for (int i = 0; i < size; i++)
      result[i][i] = 1;
    while (power > 0) {
      if ((power & 1) == 1)
        result = matrixMul(result, matrix, size);
      matrix = matrixMul(matrix, matrix, size);
      power >>= 1;
    }
    return result;
  }
}