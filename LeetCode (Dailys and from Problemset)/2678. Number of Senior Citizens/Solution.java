class Solution {
  public int countSeniors(String[] details) {
    int count = 0;
    for (String s : details) {
      if (s.charAt(11) >= '6' && (s.charAt(11) > '6' || s.charAt(12) > '0')) count++;
      // if (Integer.parseInt(s.substring(11, 13)) > 60) count++;
    }
    return count;
  }
}