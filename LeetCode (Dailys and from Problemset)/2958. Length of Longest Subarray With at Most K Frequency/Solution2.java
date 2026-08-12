import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
  public int maxSubarrayLength(int[] nums, int maxFreq) {
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> freqWindow = new HashMap<>();
    int maxLen = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      queue.add(num);
      if (freqWindow.containsKey(num)) {
        Integer freq = freqWindow.get(num);
        if (freq < maxFreq) {
          freqWindow.put(num, freq + 1);
        } else {
          while (queue.peek() != num) {
            freqWindow.put(queue.peek(), freqWindow.get(queue.peek()) - 1);
            queue.poll();
          }
          queue.poll();
        }
      } else {
        freqWindow.put(num, 1);
      }
      maxLen = Math.max(queue.size(), maxLen);
      // System.out.println(freqWindow.toString());
      // System.out.println(queue.toString());
    }
    return maxLen;
  }
}


// import java.util.HashMap;
// import java.util.Map;
// import java.util.Objects;

// class Solution {
//   public int maxSubarrayLength(int[] nums, int k) {
//     //sliding windows with map
//     int maxFreq = k;
//     Map<Integer, Integer> currentWindow = new HashMap<>();
//     int maxLen = 0;
//     int currSum = 0;
//     for (int i = 0; i < nums.length; i++) {
//       int num = nums[i];
//       if (currentWindow.containsKey(num)) {
//         Integer freq = currentWindow.get(num);
//         if (freq < maxFreq) {
//           currentWindow.put(num, freq+1);
//           currSum++;
//         }
//       } else {

//       }
//       // maxLen = Math.max(maxLen, currentWindow.values().stream().reduce(0, Integer::sum));
//       maxLen = Math.max(maxLen, currSum);
//     }
//   }
// }