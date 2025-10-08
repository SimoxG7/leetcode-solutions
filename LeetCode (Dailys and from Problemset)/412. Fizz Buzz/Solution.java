import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> lst = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      boolean divBy3 = i % 3 == 0, divBy5 = i % 5 == 0;
      if (divBy3 && divBy5) lst.add("FizzBuzz");
      else if (divBy3) lst.add("Fizz");
      else if (divBy5) lst.add("Buzz");
      else lst.add(Integer.toString(i));
    }
    return lst;
  }
}