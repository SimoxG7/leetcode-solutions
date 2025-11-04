import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int[] findXSum(int[] nums, int k, int x) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[nums.length - k + 1];

    for (int i = 0, j = 0, r = 0; j < nums.length; j++) {
      map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

      if (j >= k - 1) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int key : map.keySet()) {
          q.add(new int[] { key, map.get(key) });
        }

        int m = x, sum = 0;

        while (!q.isEmpty() && m-- > 0) {
          int[] a = q.remove();
          sum += a[0] * a[1];
        }

        res[r++] = sum;
        map.put(nums[i], map.get(nums[i++]) - 1);
      }
    }

    return res;
  }
}

// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Objects;

// class Solution {
// public int[] findXSum(int[] nums, int k, int x) {
// int n = nums.length;
// int[] res = new int[n - k + 1];
// Map<Integer, Integer> occurrences = new HashMap<>();
// for (int i = 0; i < k; i++) {
// int num = nums[i];
// occurrences.merge(num, 1, Integer::sum);
// }
// for (int i = 0; i < n - k + 1; i++) {
// List<Integer> keys = getKeysSortedByValue(occurrences);
// for (int j = 0; j < Math.min(x, keys.size()); j++) {
// Integer key = keys.get(j);
// if (Objects.isNull(key)) continue;
// res[i] += occurrences.get(key) * key;
// }
// occurrences.merge(nums[i], 1, (oldValue, newValue) -> oldValue - 1);
// if (i + k < n) occurrences.merge(nums[i + k], 1, Integer::sum);
// }
// return res;
// }

// private <K extends Comparable<? super K>, V extends Comparable<? super V>>
// List<K> getKeysSortedByValue(
// Map<K, V> map) {
// return map.entrySet().stream()
// .sorted(
// Comparator.<Map.Entry<K, V>, V>comparing(
// Map.Entry::getValue,
// Comparator.nullsLast(Comparator.reverseOrder())).thenComparing(
// Map.Entry::getKey,
// Comparator.nullsLast(Comparator.reverseOrder())))
// .map(Map.Entry::getKey)
// .toList();
// }
// }

// // private <K extends Comparable<? super K>, V extends Comparable<? super V>>
// // List<K> getKeysSortedByValue(Map<K, V> map) {
// // return map.entrySet().stream()
// // .sorted((e1, e2) -> {
// // int valueCompare = e2.getValue().compareTo(e1.getValue());
// // if (valueCompare != 0)
// // return valueCompare;
// // return e2.getKey().compareTo(e1.getKey());
// // })
// // .map(Map.Entry::getKey) // extract keys only
// // .toList();
// // }
