import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findTheLongestSubstring(String s) {
    if (s.length() < 2)
      return 0;

    int mask = 0;
    int max = -1;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // To handle the case when a balanced substring starts from the beginning

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // Update the mask if the character is a vowel
      if (isVowel(c)) {
        if (c == 'a')
          mask ^= 1;
        else if (c == 'e')
          mask ^= 2;
        else if (c == 'i')
          mask ^= 4;
        else if (c == 'o')
          mask ^= 8;
        else if (c == 'u')
          mask ^= 16;
      }

      // If the mask was seen before, calculate the length of the balanced substring
      if (!map.containsKey(mask)) {
        map.put(mask, i); // Store the first occurrence of this mask
      } else {
        max = Math.max(max, i - map.get(mask));
      }
    }

    return max;
  }

  public boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }
}