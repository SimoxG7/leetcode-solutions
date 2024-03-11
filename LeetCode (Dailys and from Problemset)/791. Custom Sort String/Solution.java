import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String customSortString(String order, String s) {
    int[] orderArray = new int[26];
    Arrays.setAll(orderArray, (n -> 99));
    for (int i = 0; i < order.length(); i++) {
      orderArray[charToPos(order.charAt(i))] = i + 1;
    }
    Character[] characters = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    Arrays.sort(characters, new Comparator<Character>() {
      @Override
      public int compare(Character o1, Character o2) {
        return orderArray[charToPos(o1)] - orderArray[charToPos(o2)];
      }
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < characters.length; i++) {
      sb.append(characters[i]);
    }
    return sb.toString();
  }

  private int charToPos(char c) {
    return c - 'a';
  }
}