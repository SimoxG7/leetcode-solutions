import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Solution {
  public String countOfAtoms(String formula) {
    int n = formula.length(), va = 1;
    Map<String, Integer> map = new TreeMap<>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      String str = "";
      int v = 1;
      if (Character.isUpperCase(formula.charAt(i))) {
        str += formula.charAt(i);
        while ((i + 1) < n && Character.isLowerCase(formula.charAt(i + 1))) {
          str += formula.charAt(i + 1);
          i++;
        }
        int sum = 0;
        while ((i + 1) < n && Character.isDigit(formula.charAt(i + 1))) {
          int a = Character.getNumericValue(formula.charAt(i + 1));
          sum = (sum * 10) + a;
          i++;
        }
        if (sum > 0) {
          v = sum;
        }
        if (va > 0) {
          v *= va;
        }
        if (map.isEmpty() || !map.containsKey(str)) {
          map.put(str, v);
        } else {
          map.put(str, map.get(str) + v);
        }
      } else if (formula.charAt(i) == '(') {
        int x = help(formula, i + 1);
        if (x == 0) {
          x = 1;
        }
        va *= x;
        list.add(x);
      } else if (formula.charAt(i) == ')') {
        va /= (list.get(list.size() - 1));
        list.remove(list.size() - 1);
      }
    }

    StringBuilder res = new StringBuilder();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        res.append(entry.getKey());
      } else {
        res.append(entry.getKey() + entry.getValue());
      }
    }
    return res.toString();
  }

  public int help(String formula, int st) {
    int sum = 0, c = 0;
    for (int i = st; i < formula.length(); i++) {
      if (formula.charAt(i) == '(') {
        c++;
      } else if (formula.charAt(i) == ')') {
        if (c == 0) {
          while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
            int a = Character.getNumericValue(formula.charAt(i + 1));
            sum = (sum * 10) + a;
            i++;
          }
          break;
        } else {
          c--;
        }
      }
    }
    return sum;
  }
}