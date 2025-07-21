import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {

  private final List<Integer> elements;
  private final Map<Integer, Set<Integer>> elementToIndexes;
  private int totSize;
  private final Random randomGenerator;

  public RandomizedCollection() {
    elements = new ArrayList<>();
    elementToIndexes = new HashMap<>();
    randomGenerator = new Random();
    totSize = 0;
  }

  public boolean insert(int val) {
    Set<Integer> indexes = elementToIndexes.get(val);
    boolean isNotPresent = Objects.isNull(indexes);
    if (isNotPresent) {
      indexes = new HashSet<>();
      elementToIndexes.put(val, indexes);
    }
    indexes.add(totSize++);
    elements.add(val);
    return isNotPresent;
  }

  public boolean remove(int val) {
    Set<Integer> indexes = elementToIndexes.get(val);
    if (Objects.isNull(indexes)) return false;
    int index = indexes.iterator().next();
    if (indexes.size() == 1) {
      elementToIndexes.remove(val);
    } else {
      indexes.remove(index);
    }
    elements.set(index, elements.removeLast());
    //still need to update index position
    totSize--;
    return true;
  }

  public int getRandom() {
    return elements.get(randomGenerator.nextInt(totSize));
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */