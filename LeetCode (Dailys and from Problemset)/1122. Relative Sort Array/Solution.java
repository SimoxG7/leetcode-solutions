import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> orderMap = new HashMap<>();
    Set<Integer> withSpecifiedOrder = new HashSet<>();
    for (int i = 0; i < arr1.length; i++) {
      withSpecifiedOrder.add(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      orderMap.put(arr2[i], i);
      withSpecifiedOrder.remove(arr2[i]);
    }
    Set<Integer> remainingToOrderNaturally = new TreeSet<>(withSpecifiedOrder);
    int index = arr2.length;
    for (Integer num : remainingToOrderNaturally) {
      orderMap.put(num, index++);
    }
    Integer[] boxed = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
    Arrays.sort(boxed, new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return orderMap.get(o1) - orderMap.get(o2);
      }
      
    });
    return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
  }
}