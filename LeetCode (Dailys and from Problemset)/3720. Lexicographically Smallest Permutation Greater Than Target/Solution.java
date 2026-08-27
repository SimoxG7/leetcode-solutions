class Solution {

  public String lexGreaterPermutation(String s, String target) {

    int[] count = new int[26];

    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }

    int pos = -1;
    char bigger = ' ';

    for (int i = 0; i < s.length(); i++) {

      char need = target.charAt(i);

      for (char ch = (char) (need + 1); ch <= 'z'; ch++) {

        if (count[ch - 'a'] > 0) {
          pos = i;
          bigger = ch;
          break;
        }
      }

      if (count[need - 'a'] == 0) {
        break;
      }

      count[need - 'a']--;
    }

    if (pos == -1) {
      return "";
    }

    count = new int[26];

    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }

    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < pos; i++) {
      char ch = target.charAt(i);

      ans.append(ch);
      count[ch - 'a']--;
    }

    ans.append(bigger);
    count[bigger - 'a']--;

    for (char ch = 'a'; ch <= 'z'; ch++) {

      while (count[ch - 'a'] > 0) {
        ans.append(ch);
        count[ch - 'a']--;
      }
    }

    return ans.toString();
  }
}