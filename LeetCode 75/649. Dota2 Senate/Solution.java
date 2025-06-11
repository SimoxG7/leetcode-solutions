class Solution {
  public String predictPartyVictory(String senate) {
    int n = senate.length();
    int r = 0, d = 0;
    boolean[] canvote = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') r++;
      else d++;
      canvote[i] = true;
    } 
    while (r > 0 && d > 0) {
      for (int i = 0; i < n; i++) {
        if (canvote[i]) {
          if (senate.charAt(i) == 'R') {
            for (int j = 0; j < n; j++) {
              int pos = (j + i) % n;
              if (senate.charAt(pos) == 'D' && canvote[pos]) {
                canvote[pos] = !canvote[pos];
                d--;
                break;
              }
            }
            if (d == 0) return "Radiant";
          } else {
            for (int j = 0; j < n; j++) {
              int pos = (j + i) % n;
              if (senate.charAt(pos) == 'R' && canvote[pos]) {
                canvote[pos] = !canvote[pos];
                r--;
                break;
              }
            }
            if (r == 0) return "Dire";
          }
        }
      }
    }
    if (d <= 0) return "Radiant";
    return "Dire";
  }
}