class Solution {
  public int findComplement(int num) {
    String binary = Integer.toBinaryString(num);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < binary.length(); i++) {
      stringBuilder.append((binary.charAt(i) - '0') ^ 1);
    }
    return Integer.parseInt(stringBuilder.toString(), 2);
  }
}