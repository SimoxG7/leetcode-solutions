import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

  List<int[]> track;
  List<int[]> doubleBook;

  public MyCalendarTwo() {
    track = new ArrayList<>();
    doubleBook = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    for (int[] event : doubleBook) {
      if (Math.max(start, event[0]) < Math.min(end, event[1])) {
        return false;
      }
    }

    for (int[] event : track) {
      if (Math.max(start, event[0]) < Math.min(end, event[1])) {
        doubleBook.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
      }
    }

    track.add(new int[] { start, end });
    return true;
  }
}