import java.util.Stack;

class Solution {
  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();
    int curnum = 0;
    String curstr = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        stack.push(curstr);
        stack.push("" + curnum);
        curnum = 0;
        curstr = "";
      } else if (s.charAt(i) == ']') {
        int num = Integer.parseInt(stack.pop());
        String str = stack.pop();
        curstr = str + curstr.repeat(num);
      } else if (Character.isDigit(s.charAt(i))) {
        curnum = curnum * 10 + Integer.parseInt("" + s.charAt(i));
      } else
        curstr += s.charAt(i);
    }
    return curstr;
  }
}

// import java.util.Arrays;

// class Solution {
// public String decodeString(String s) {
// StringBuilder sb = new StringBuilder();

// String[] split = s.split("\\]");

// String[] val = new String[split.length];
// int[] times = new int[split.length];

// for (int i = 0; i < split.length; i++) {
// String t = split[i];
// String[] temp = t.split("\\[");
// times[i] = Integer.parseInt(temp[0]);
// val[i] = temp[1];
// }

// System.out.println("times: " + Arrays.toString(times));
// System.out.println("val: " + Arrays.toString(val));

// for (int i = 0; i < split.length; i++) {
// for (int j = 0; j < times[i]; j++) {
// sb.append(val[i]);
// }
// }

// return sb.toString();
// }
// }