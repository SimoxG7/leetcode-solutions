import java.util.Stack;

class Solution {
  public int sumSubarrayMins(int[] arr) {
    final int MOD = 1000000007;
    Stack<Integer> stack = new Stack<>();
    long minSum = 0;
    for (int i = 0; i <= arr.length; i++) {
      while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
        int mid = stack.pop();
        int left = stack.empty() ? -1 : stack.peek();
        int right = i;
        long cont = (mid - left) * (right - mid) % MOD;
        minSum += (cont * arr[mid]) % MOD;
        minSum %= MOD;
      }
      stack.push(i);
    }
    return (int) minSum;
  }
}
