class Solution {
  public int[] findBall(int[][] grid) {
    int rows = grid.length; 
    int cols = grid[0].length; 
    int[] res = new int[cols];
    for (int i = 0; i < cols; i++) {
      int ballpos = i;
      for (int j = 0; j < rows; j++) {
        if (grid[j][ballpos] == 1) { 
          if (ballpos == cols-1 || grid[j][ballpos + 1] == -1) {
            res[i] = -1;
            break;
          }
          ballpos++;
        } else {
          if (ballpos == 0 || grid[j][ballpos - 1] == 1) {
            res[i] = -1;
            break;
          }
          ballpos--;
        }
        res[i] = ballpos;
      }
    }
    return res;
  }
}


//this is actually what the problem should have asked imo... 
// class Solution {
//   public int[] findBall(int[][] grid) {
//     int rows = grid.length; 
//     int cols = grid[0].length; 
//     int[] res = new int[cols];
//     for (int i = 0; i < cols; i++) {
//       int ballpos = i;
//       for (int j = 0; j < rows; j++) {
//         if (grid[j][ballpos] == 1) { 
//           if (ballpos == cols-1 || grid[j][ballpos + 1] == -1) {
//             res[i] = ballpos;
//             break;
//           }
//           ballpos++;
//         } else {
//           if (ballpos == 0 || grid[j][ballpos - 1] == 1) {
//             res[i] = ballpos;
//             break;
//           }
//           ballpos--;
//         }
//       }
//       res[i] = ballpos;
//     }
//     return res;
//   }
// }