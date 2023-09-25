import java.util.HashMap;
import java.util.Map;

class Solution {

  class Pair<T1, T2> {

    private T1 key;
    private T2 value;

    public Pair(T1 key, T2 value) {
      this.key = key;
      this.value = value;
    }

    public T1 getKey() {return this.key;}
    public T2 getValue() {return this.value;}

  }

  public int longestConsecutive(int[] nums) {
    Map<Integer, Pair<Integer, Integer>> mp = new HashMap<>();
    Map<Integer, Boolean> bl = new HashMap<>();
    int mx = 0;

    for (int i : nums) {
      if (bl.containsKey(i)) {
        continue;
      }
      bl.put(i, true);
      int l = i, r = i;

      if (mp.containsKey(i + 1)) {
        r = mp.get(i + 1).getKey();
      }
      if (mp.containsKey(i - 1)) {
        l = mp.get(i - 1).getValue();
      }
      mp.put(r, new Pair<>(r, l));
      mp.put(l, new Pair<>(r, l));
      mx = Math.max(mx, r - l + 1);
    }

    return mx;
  }
}

