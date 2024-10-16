class Solution {
    
  class Pair {
    int count;
    char ch;
    
    Pair(int count, char ch) {
      this.count = count;
      this.ch = ch;
    }
  }
  
  public String longestDiverseString(int a, int b, int c) {
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
    
    if (a > 0) pq.offer(new Pair(a, 'a'));
    if (b > 0) pq.offer(new Pair(b, 'b'));
    if (c > 0) pq.offer(new Pair(c, 'c'));
    
    while (!pq.isEmpty()) {
      Pair maxPair = pq.poll();
      if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == maxPair.ch && sb.charAt(sb.length() - 2) == maxPair.ch) {
        if (pq.isEmpty()) break;
        
        Pair nextPair = pq.poll();
        sb.append(nextPair.ch);
        nextPair.count--;
        
        if (nextPair.count > 0) pq.offer(nextPair);
        pq.offer(maxPair);
      } else {
        sb.append(maxPair.ch);
        maxPair.count--;
        if (maxPair.count > 0) pq.offer(maxPair);
      }
    }
    
    return sb.toString();
  }

}