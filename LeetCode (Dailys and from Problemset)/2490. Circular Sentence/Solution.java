class Solution {
  public boolean isCircularSentence(String sentence) {
    String[] splits = sentence.split(" ");
    if (splits[0].charAt(0) != splits[splits.length - 1].charAt(splits[splits.length - 1].length() - 1)) return false;
    for (int i = 0; i < splits.length - 1; i++) {
      if (splits[i].charAt(splits[i].length() - 1) != splits[i + 1].charAt(0)) return false;
    }
    return true;
  }
}