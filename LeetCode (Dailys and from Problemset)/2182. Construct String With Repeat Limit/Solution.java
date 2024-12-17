class Solution {
  public int getNext(int count[], int curr) {
    if (curr == 0)
      return -1;
    while (curr > 0) {
      if (count[curr - 1] > 0)
        return curr - 1;
      curr--;
    }
    return -1;
  }

  public String repeatLimitedString(String s, int repeatLimit) {
    int count[] = new int[26];
    StringBuilder sb = new StringBuilder();
    for (char ch : s.toCharArray())
      count[ch - 'a']++;

    int curr = getNext(count, 26);

    while (curr >= 0) {
      int freq = Math.min(repeatLimit, count[curr]);
      for (int i = 0; i < freq; i++)
        sb.append((char) (curr + 'a'));
      count[curr] -= freq;
      if (count[curr] > 0) {
        int next = getNext(count, curr);
        if (next < 0)
          break;
        sb.append((char) (next + 'a'));
        count[next]--;
      } else
        curr = getNext(count, curr);
    }

    return sb.toString();

  }
}