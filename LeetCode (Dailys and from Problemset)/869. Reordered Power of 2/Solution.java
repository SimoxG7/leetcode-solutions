import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean reorderedPowerOf2(int n) {
    Set<String> powersOf2StringsSorted = new HashSet<>(Arrays.asList("011237", "0122579", "012356789", "0124", "0134449", "0145678", "01466788", "0248", "0368888", "0469", "1", "112234778", "11266777", "122446", "125", "128", "1289", "13468", "16", "2", "224588", "23", "23334455", "234455668", "23678", "256", "35566", "4", "46", "8"));
    char[] numStringChars = String.valueOf(n).toCharArray();
    Arrays.sort(numStringChars);
    String sortedNumString = new String(numStringChars);
    return powersOf2StringsSorted.contains(sortedNumString);
  }
}