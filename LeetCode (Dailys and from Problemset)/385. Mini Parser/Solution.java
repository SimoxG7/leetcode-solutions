import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {

  public interface NestedInteger {
    // // Constructor initializes an empty nested list.
    // public NestedInteger();

    // // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public NestedInteger deserialize(String s) {
    if (s.isEmpty())
      return null;
    if (s.charAt(0) != '[') // ERROR: special case
      return new NestedInteger(Integer.valueOf(s));

    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int l = 0; // l shall point to the start of a number substring;
               // r shall point to the end+1 of a number substring
    for (int r = 0; r < s.length(); r++) {
      char ch = s.charAt(r);
      if (ch == '[') {
        if (curr != null) {
          stack.push(curr);
        }
        curr = new NestedInteger();
        l = r + 1;
      } else if (ch == ']') {
        String num = s.substring(l, r);
        if (!num.isEmpty())
          curr.add(new NestedInteger(Integer.valueOf(num)));
        if (!stack.isEmpty()) {
          NestedInteger pop = stack.pop();
          pop.add(curr);
          curr = pop;
        }
        l = r + 1;
      } else if (ch == ',') {
        if (s.charAt(r - 1) != ']') {
          String num = s.substring(l, r);
          curr.add(new NestedInteger(Integer.valueOf(num)));
        }
        l = r + 1;
      }
    }

    return curr;
  }
}

// Given a string s represents the serialization of a nested list, implement a
// parser to deserialize it and return the deserialized NestedInteger.

// Each element is either an integer or a list whose elements may also be
// integers or other lists.

// Example 1:

// Input: s = "324"
// Output: 324
// Explanation: You should return a NestedInteger object which contains a single
// integer 324.

// Example 2:

// Input: s = "[123,[456,[789]]]"
// Output: [123,[456,[789]]]
// Explanation: Return a NestedInteger object containing a nested list with 2
// elements:
// 1. An integer containing value 123.
// 2. A nested list containing two elements:
// i. An integer containing value 456.
// ii. A nested list with one element:
// a. An integer containing value 789

// Constraints:

// 1 <= s.length <= 5 * 104
// s consists of digits, square brackets "[]", negative sign '-', and commas
// ','.
// s is the serialization of valid NestedInteger.
// All the values in the input are in the range [-106, 106].