class Solution {
  public int lengthOfLastWord(String s) {
    boolean started = false;
    int cont = 0;
    for (int i = s.length()-1; i >= 0; i--) {
      //System.out.println(s.charAt(i) + " " + cont);
      if (started) {
        if (s.charAt(i) == ' ') break;
        else cont++;
      } else {
        if (s.charAt(i) != ' ') {
          started = true;
          cont++;
        } 
      }
    }
    return cont;
  }
}