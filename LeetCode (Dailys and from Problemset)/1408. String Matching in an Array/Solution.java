import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
  public List<String> stringMatching(String[] words) {
    List<String> lst = new ArrayList<>();
    int n = words.length;

    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    });

    for (int i = 0; i < n - 1; i++) {
      String shortWord = words[i];
      boolean contained = false;
      for (int j = i + 1; j < n; j++) {
        String longWord = words[j];
        if (longWord.contains(shortWord)) {
          contained = true;
          break;
        }
      }
      if (contained) lst.add(shortWord);
    }
    return lst;
  }
}

// class Solution {
//   public List<String> stringMatching(String[] words) {
//     List<String> lst = new ArrayList<>();
//     int n = words.length;
//     for (int i = 0; i < n - 1; i++) {
//       for (int j = i + 1; j < n; j++) {
//         String s1 = words[i], s2 = words[j];
//         if (s1.contains(s2)) {
//           if (!lst.contains(s2)) lst.add(s2); 
//         }
//         if (s2.contains(s1)) {
//           if (!lst.contains(s1)) lst.add(s1); 
//         }
//       }
//     }
//     return lst;
//   }
// }