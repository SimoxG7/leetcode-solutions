class Solution {
  public int numberOfBeams(String[] bank) {
    int[] acc = new int[bank.length];
    int size = 0;
    for (int i = 0; i < bank.length; i++) {
      char[] curr = bank[i].toCharArray();
      int cont = 0;
      for (int j = 0; j < curr.length; j++) {
        if (curr[j] == '1') cont++; 
      }
      if (cont > 0) acc[size++] = cont;
    }
    int res = 0;
    for (int i = 1; i < size; i++) {
      res += acc[i-1] * acc[i];
    }
    return res;
  }
}