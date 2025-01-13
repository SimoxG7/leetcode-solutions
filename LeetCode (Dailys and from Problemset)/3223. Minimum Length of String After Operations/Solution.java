class Solution {
  public int minimumLength(String s) {
    int[] count = new int[26];
    
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }

    int sum = 0;
    
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 2) {
        if (count[i] % 2 == 1) count[i] = 1;
        else count[i] = 2;
      }
      sum += count[i];
    }
    
    return sum;
  }
}