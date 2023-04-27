// class Solution {
//   public int bulbSwitch(int n) {
//     boolean[] bulbs = new boolean[n];
//     for (int i = 1; i <= n; i++) {
//       // for (int j = 0; j < n; j++) {
//       // if ((j+1) % i == 0) bulbs[j] = !bulbs[j];
//       // }
//       for (int j = i; j <= n; j += i) {
//         bulbs[j - 1] = !bulbs[j - 1];
//       }
//     }
//     int cont = 0;
//     for (int i = 0; i < n; i++) {
//       if (bulbs[i])
//         cont++;
//     }
//     return cont;
//   }
// }

class Solution {
  public int bulbSwitch(int n) {
    return (int) Math.sqrt(n);
  }
}