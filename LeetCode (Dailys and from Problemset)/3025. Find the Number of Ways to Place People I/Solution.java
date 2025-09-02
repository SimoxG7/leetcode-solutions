import java.util.Arrays;

class Solution {
  public int numberOfPairs(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int count = 0;
    for (int i = 0; i < points.length; i++) {
      int yA = points[i][1];
      int bot = Integer.MIN_VALUE, top = yA;
      for (int j = i + 1; j < points.length; j++) {
        int yB = points[j][1];
        if (yB <= top && yB > bot) {
          count++;
          bot = yB;
          if (yB == top) top--;
        }
      }
    }
    return count;
  }
}

// class Solution {
//   public int numberOfPairs(int[][] points) {
//     int n = points.length;
//     int count = 0;
//     final int X = 0, Y = 1;
//     for (int i = 0; i < n; i++) {
//       for (int j = i + 1; j < n; j++) {
//         int[] pointA = points[i];
//         int[] pointB = points[j];
//         if (pointA[X] > pointB[X] || pointA[Y] < pointB[Y]) {
//           if (pointB[X] > pointA[X] || pointB[Y] < pointA[Y]) continue;
//           else { //swapping pointA and pointB as pointB is currently upperLeft
//             int[] temp = pointA;
//             pointA = pointB;
//             pointB = temp;
//           }
//         } // from this point forward pointA is upperLeft, pointB is lowerRight
//         boolean foundPointInBetween = false;
//         for (int k = 0; k < n; k++) {
//           if (k == i || k == j) continue;
//           int[] pointC = points[k];
//           if (
//             (pointC[X] >= pointA[X] && pointC[X] <= pointB[X])
//             && (pointC[Y] >= pointB[Y] && pointC[Y] <= pointA[Y])
//           ) {
//             foundPointInBetween = true;
//             break;
//           }
//         }
//         if (!foundPointInBetween) {
//           count++;
//         }
//       }
//     }
//     return count;
//   }
// }