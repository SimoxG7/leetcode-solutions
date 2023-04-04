class Solution {
  public int partitionString(String s) {
    boolean[] occurr = new boolean[26];
    int cont = 0;
    for (int i = 0; i < s.length(); i++) {
      int pos = s.charAt(i) - 'a';
      if (occurr[pos]) {
        cont++;
        occurr = new boolean[26];
      }
      occurr[pos] = true;
    }
    return cont+1;
  }
}

