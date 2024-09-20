class Solution {
  public String shortestPalindrome(String s) {
    final String t = new StringBuilder(s).reverse().toString();
    for (int i = 0; i < t.length(); ++i) {
      if (s.startsWith(t.substring(i))) return t.substring(0, i) + s;
    }
    return t + s;
  }
}

// class Solution {
//   public String shortestPalindrome(String s) {
//     if (s.length() < 2) return s;
//     boolean even = s.length() % 2 == 0;
//     String res;
//     if (even) {
//       res = handleEven(s);
//     } else {
//       res = handleOdd(s);
//     }
//     StringBuilder rev = new StringBuilder(res);
//     rev.deleteCharAt(0);
//     return rev.reverse().toString() + res;
//   }

//   private String handleOdd(String s) {
//     int half = s.length() / 2;
//     StringBuilder left = new StringBuilder(s.substring(0, half));
//     char pivot = s.charAt(half);
//     StringBuilder right = new StringBuilder(s.substring(half+1, s.length()));
//     System.out.println(left);
//     System.out.println(pivot);
//     System.out.println(right);
//     return "a";
//   }

//   private String handleEven(String s) {
//     int half = s.length() / 2;
//     StringBuilder left = new StringBuilder(s.substring(0, half));
//     StringBuilder right = new StringBuilder(s.substring(half, s.length()));
//     int leftLen = left.length();
//     while (leftLen > 0 && !isPalindrome(left, right)) {
//       right = right.insert(0, left.charAt(leftLen-1));
//       left = left.deleteCharAt(leftLen-1);
//       leftLen--;
//     }
//     return right.toString();
//   }

//   private boolean isPalindrome(StringBuilder left, StringBuilder right) {
//     StringBuilder rightCopy = new StringBuilder(right);
//     return left.toString().equals(rightCopy.reverse().toString());
//   }
// }