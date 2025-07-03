class Solution {
  public char kthCharacter(int k) {
    StringBuilder stringBuilder = new StringBuilder("a");
    while (stringBuilder.length() < k) {
      applyOperation(stringBuilder);
    }
    return stringBuilder.charAt(k - 1);
  }

  private void applyOperation(StringBuilder stringBuilder) {
    for (char c : stringBuilder.toString().toCharArray()) {
      if (c == 'z') stringBuilder.append('a');
      else stringBuilder.append((char) (c + 1));
    }
  }
}