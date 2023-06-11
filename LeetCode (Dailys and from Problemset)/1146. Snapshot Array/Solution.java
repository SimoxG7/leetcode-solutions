import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
  private List<TreeMap<Integer, Integer>> array;
  private int snapId;

  public SnapshotArray(int length) {
    array = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      array.add(new TreeMap<>());
      array.get(i).put(0, 0);
    }
    snapId = 0;
  }

  public void set(int index, int val) {
    array.get(index).put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snapId) {
    TreeMap<Integer, Integer> history = array.get(index);
    return history.floorEntry(snapId).getValue();
  }
}

// import java.util.ArrayList;
// import java.util.List;

// class SnapshotArray {

// List<int[]> mat;
// int length;
// int snap_id;
// int[] current;

// public SnapshotArray(int length) {
// this.mat = new ArrayList<>();
// this.length = length;
// this.snap_id = 0;
// this.current = new int[length];
// }

// public void set(int index, int val) {
// current[index] = val;
// }

// public int snap() {
// mat.add(current);
// int[] newcurrent = new int[length];
// for (int i = 0; i < length; i++) {
// newcurrent[i] = current[i];
// }
// current = newcurrent;
// return snap_id++;
// }

// public int get(int index, int snap_id) {
// return mat.get(snap_id)[index];
// }
// }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */