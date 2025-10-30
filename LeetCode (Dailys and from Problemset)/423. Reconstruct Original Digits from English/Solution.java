class Solution {
  public String originalDigits(String s) {
    int[] charCount = new int[26];
    for (char c : s.toCharArray()) {
      charCount[c - 'a']++;
    }

    int[] digitCount = new int[10];

    digitCount[0] = charCount['z' - 'a'];
    digitCount[2] = charCount['w' - 'a'];
    digitCount[4] = charCount['u' - 'a'];
    digitCount[6] = charCount['x' - 'a'];
    digitCount[8] = charCount['g' - 'a'];

    digitCount[3] = charCount['h' - 'a'] - digitCount[8];
    digitCount[5] = charCount['f' - 'a'] - digitCount[4];
    digitCount[7] = charCount['s' - 'a'] - digitCount[6];

    digitCount[1] = charCount['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4];
    digitCount[9] = charCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < digitCount[i]; j++) {
        result.append(i);
      }
    }

    return result.toString();
  }
}

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Solution {
// public String originalDigits(String s) {
// List<Character> lst = List.of('z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's',
// 'n');
// Map<Character, String> mapUniqueCharToString = Map.of('z', "zero", 'w',
// "two", 'u', "four", 'x', "six", 'g', "eight", 'o', "one", 'h', "three", 'f',
// "five", 's', "seven", 'n', "nine");
// Map<Character, Integer> mapUniqueCharToInteger = Map.of('z', 0, 'w', 2, 'u',
// 4, 'x', 6, 'g', 8, 'o', 1, 'h', 3, 'f', 5, 's', 7, 'n', 9);
// Map<Integer, Integer> countMap = new HashMap<>();
// Map<Character, Integer> map = new HashMap<>();
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// map.merge(c, 1, Integer::sum);
// }
// StringBuilder result = new StringBuilder();
// for (char c : lst) {
// int occurr = map.getOrDefault(c, 0);
// if (occurr == 0) continue;
// int digit = mapUniqueCharToInteger.get(c);
// String fullNumberString = mapUniqueCharToString.get(c);
// for (int i = 0; i < fullNumberString.length(); i++) {
// char sub = fullNumberString.charAt(i);
// map.put(sub, map.get(sub) - occurr);
// }
// countMap.put(digit, occurr);
// }
// for (int i = 0; i < 10; i++) {
// int occurr = countMap.getOrDefault(i, 0);
// result.append(Integer.toString(i).repeat(occurr));
// }
// return result.toString();
// }
// }