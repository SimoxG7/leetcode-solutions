class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int size = hand.length;
    if (size % groupSize != 0)
      return false;

    Arrays.sort(hand);
    boolean[] check = new boolean[size];
    int index = 0, limit;

    while (index < size) {
      limit = 1;
      if (!check[index]) {
        check[index] = true;
        int prev = index;
        int trav = index + 1;
        while (trav < size && limit < groupSize) {
          if (!check[trav]) {
            if (hand[trav] == hand[prev]) {
              trav++;
            } else if (hand[trav] == hand[prev] + 1) {
              prev = trav;
              check[trav++] = true;
              limit++;
            } else {
              return false;
            }
          } else
            trav++;

        }
        if (limit != groupSize)
          return false;
      }
      index++;
    }

    return true;
  }
}
