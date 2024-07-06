class Solution {
  public int passThePillow(int n, int time) {
    time = time % (2 * (n - 1));
    int pos = 1;
    boolean forward = true;
    while(time > 0) {
        // System.out.println("BEFORE - TIME: " + time + " - POS: " + pos);
        if (pos >= n) forward = false;
        if (forward) pos++;
        else pos--;
        time--;
        // System.out.println("AFTER - TIME: " + time + " - POS: " + pos);
    }
    return pos;
  }
}