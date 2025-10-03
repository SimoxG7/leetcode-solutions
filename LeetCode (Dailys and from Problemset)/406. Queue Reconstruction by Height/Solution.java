import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[][] reconstructQueue(int[][] people) {

    // Sorting in descending orders of height
    // If same height, sorting in ascending order of people ahead;
    Arrays.sort(people, (a, b) -> {
      if (a[0] == b[0])
        return a[1] - b[1];
      return b[0] - a[0];
    });

    List<int[]> result = new ArrayList<>();
    for (int[] p : people) {
      result.add(p[1], p);
    }

    return result.toArray(new int[result.size()][]);
  }
}

// import java.util.Arrays;

// class Solution {
// public int[][] reconstructQueue(int[][] people) {
// Arrays.sort(people, (a, b) -> {
// if (a[0] == b[0]) return a[1] - b[1];
// return b[0] - a[0];
// });

// //array shifting instead of list.add(index, val)
// for (int i = 0; i < people.length; i++) {
// int idx = people[i][1];
// if (idx < i) {
// int[] temp = people[i];
// // shift elements right by one
// for (int j = i; j > idx; j--) {
// people[j] = people[j - 1];
// }
// people[idx] = temp;
// }
// }
// return people;
// }

// }