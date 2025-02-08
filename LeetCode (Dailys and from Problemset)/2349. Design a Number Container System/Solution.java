import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class NumberContainers {

  private final Map<Integer, Set<Integer>> numberToIndexesMap;
  private final Map<Integer, Integer> indexToNumberMap;

  public NumberContainers() {
    numberToIndexesMap = new HashMap<>();
    indexToNumberMap = new HashMap<>();
  }

  public void change(int index, int number) {
    if (indexToNumberMap.containsKey(index)) {
      int prevNumber = indexToNumberMap.get(index);
      Set<Integer> prevIndexes = numberToIndexesMap.get(prevNumber);
      prevIndexes.remove(index);
      numberToIndexesMap.put(prevNumber, prevIndexes);
    }
    Set<Integer> indexSet = numberToIndexesMap.getOrDefault(number, new TreeSet<>());
    indexSet.add(index);
    numberToIndexesMap.put(number, indexSet);
    indexToNumberMap.put(index, number);
  }

  public int find(int number) {
    if (numberToIndexesMap.containsKey(number)) {
      Iterator<Integer> iterator = numberToIndexesMap.get(number).iterator();
      if (iterator.hasNext()) return iterator.next();
    }
    return -1;
  }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

// import java.util.HashMap;
// import java.util.Map;
// import java.util.PriorityQueue;
// import java.util.Queue;

// class NumberContainers {

//   private final Map<Integer, Queue<Integer>> numberToIndexesMap;
//   private final Map<Integer, Integer> indexToNumberMap;

//   public NumberContainers() {
//     numberToIndexesMap = new HashMap<>();
//     indexToNumberMap = new HashMap<>();
//   }

//   public void change(int index, int number) {
//     if (indexToNumberMap.containsKey(index)) {
//       int prevNumber = indexToNumberMap.get(index);
//       Queue<Integer> prevIndexes = numberToIndexesMap.get(prevNumber);
//       prevIndexes.remove(index);
//       numberToIndexesMap.put(prevNumber, prevIndexes);
//     }
//     Queue<Integer> indexQueue = numberToIndexesMap.getOrDefault(number, new PriorityQueue<>());
//     indexQueue.add(index);
//     numberToIndexesMap.put(number, indexQueue);
//     indexToNumberMap.put(index, number);
//   }

//   public int find(int number) {
//     if (numberToIndexesMap.containsKey(number)) {
//       Queue<Integer> indexQueue = numberToIndexesMap.get(number);
//       if (!indexQueue.isEmpty()) return indexQueue.peek();
//     }
//     return -1;
//   }
// }

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */