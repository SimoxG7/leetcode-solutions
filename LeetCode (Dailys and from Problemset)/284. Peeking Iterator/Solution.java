// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

  private final Iterator<Integer> iterator;
  private boolean empty;
  private int currentPeek;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    empty = this.iterator.hasNext();
    if (!empty) currentPeek = iterator.next();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return currentPeek;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (iterator.hasNext()) {
      empty = false;
      currentPeek = iterator.next();
    } else empty = true;
    return currentPeek;
  }

  @Override
  public boolean hasNext() {
    return empty;
  }
}

// // Java Iterator interface reference:
// // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.List;

// class PeekingIterator implements Iterator<Integer> {

//   private final List<Integer> iterator;

//   public PeekingIterator(Iterator<Integer> iterator) {
//     // initialize any member here.
//     this.iterator = new ArrayList<>();
//     while (iterator.hasNext()) this.iterator.add(iterator.next());
//   }

//   // Returns the next element in the iteration without advancing the iterator.
//   public Integer peek() {
//     return this.iterator.get(0);    
//   }

//   // hasNext() and next() should behave the same as in the Iterator interface.
//   // Override them if needed.
//   @Override
//   public Integer next() {
//     return this.iterator.remove(0);
//   }

//   @Override
//   public boolean hasNext() {
//     return this.iterator.size() > 0;
//   }
// }