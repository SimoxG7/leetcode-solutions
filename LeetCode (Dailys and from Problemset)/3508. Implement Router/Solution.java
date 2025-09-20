import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Router {

  class DataPacket {
    public int source, dest, timestamp;

    DataPacket(int source, int dest, int timestamp) {
      this.source = source;
      this.dest = dest;
      this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      DataPacket packet = (DataPacket) obj;
      return source == packet.source &&
          dest == packet.dest &&
          timestamp == packet.timestamp;
    }

    @Override
    public int hashCode() {
      // Don’t use memory address. Instead, compute a number based on the fields that
      // define equality.
      return Objects.hash(source, dest, timestamp);
    }
  }

  Set<DataPacket> set;
  Deque<DataPacket> deque; // FIFO queue
  HashMap<Integer, List<Integer>> destinationMap; // dest → sorted timestamps
  int limit;

  public Router(int memoryLimit) {
    limit = memoryLimit;
    set = new HashSet<>();
    deque = new ArrayDeque<>();
    destinationMap = new HashMap<>();
  }

  public boolean addPacket(int source, int dest, int timestamp) {
    DataPacket packet = new DataPacket(source, dest, timestamp);

    // checking for duplicate packet
    if (set.contains(packet)) {
      return false;
    }

    // evict the oldest packet if limit is reached
    if (deque.size() == limit) {
      DataPacket p = deque.remove();
      set.remove(p);

      List<Integer> timestamps = destinationMap.get(p.dest); // O(n)

      timestamps.remove(0);
      if (timestamps.isEmpty()) {
        destinationMap.remove(p.dest);
      }
    }

    // add new packet
    set.add(packet);
    deque.offer(packet);

    destinationMap.computeIfAbsent(dest, k -> new ArrayList<>());
    destinationMap.get(dest).add(timestamp);

    return true;
  }

  public int[] forwardPacket() {

    // O(1)
    if (deque.isEmpty()) {
      return new int[0];
    }

    DataPacket p = deque.remove();
    set.remove(p);

    List<Integer> timestamps = destinationMap.get(p.dest);

    timestamps.remove(0); // O(n)
    if (timestamps.isEmpty()) {
      destinationMap.remove(p.dest);
    }

    return new int[] { p.source, p.dest, p.timestamp };
  }

  public int getCount(int destination, int startTime, int endTime) {
    if (!destinationMap.containsKey(destination)) {
      return 0;
    }

    List<Integer> list = destinationMap.get(destination);
    int left = lowerBound(list, startTime); // first ≥ startTime
    int right = upperBound(list, endTime); // first > endTime
    return right - left;
  }

  private int lowerBound(List<Integer> list, int target) {
    int lo = 0, hi = list.size();
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (list.get(mid) < target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  private int upperBound(List<Integer> list, int target) {

    int lo = 0, hi = list.size();
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (list.get(mid) <= target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

/**
 * Router Memory Table (size: 3)
 * 
 * | **Queue Order (FIFO)** | **Source** | **Destination** | **Timestamp** |
 * | ---------------------- | ---------- | --------------- | ------------- |
 * | 3 | 3 | 5 | 95 |
 * | 4 | 4 | 5 | 105 |
 * | 5 | 5 | 2 | 110 |
 * 
 * 
 * Data Structures:
 * 1. FIFO Queue Deque [p1, p2, p3, p4]
 * 2. HashSet - to check for duplicate packets
 * 3. Dest --> [list of timestamps] [MAP]
 * 
 * add packet
 * [1,4,90]
 * [2,5,90]
 * [1,4,90] X
 * [3,5,95]
 * [4,5,105]
 * <--forward packet-->
 * add packet
 * [5,2,110]
 * get count [5,100,110] = 1
 * 
 * 
 */