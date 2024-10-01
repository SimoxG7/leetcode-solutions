import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean canArrange(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int countzero = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] % k;
      if (arr[i] == 0)
        countzero++;
      else
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    if (countzero % 2 != 0)
      return false;
    for (int i = 0; i < arr.length; i++) {

      int num = -1 * arr[i];
      if (map.containsKey(num)) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0)
          map.remove(num);
      } else {

        if (arr[i] > 0) {
          num = k - arr[i];
          if (map.containsKey(num)) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0)
              map.remove(num);
          }
        } else {
          num = -1 * k - arr[i];
          if (map.containsKey(num)) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0)
              map.remove(num);
          }
        }
      }
    }
    return map.isEmpty();
  }
}

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Objects;

// class Solution {
// public boolean canArrange(int[] arr, int k) {
// Map<Integer, Integer> map = new HashMap<>();
// boolean evenZeros = true;
// for (int i = 0; i < arr.length; i++) {
// int rem = arr[i] % k;
// if (rem == 0) evenZeros = !evenZeros;
// else map.put(rem, map.getOrDefault(rem, 0) + 1);
// }
// if (!evenZeros) return false;
// for (int i = 1; i < k/2; i++) {
// if (!Objects.equals(map.getOrDefault(i, 0), map.getOrDefault(k - i, 0)))
// return false;
// }
// return true;
// }
// }