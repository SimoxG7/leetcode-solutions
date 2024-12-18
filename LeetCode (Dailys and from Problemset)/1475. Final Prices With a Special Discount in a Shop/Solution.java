import java.util.Stack;

class Solution {
  public int[] finalPrices(int[] prices) {
    int n=prices.length;
    Stack <Integer> st=new Stack<>();
    for(int i = 0; i < n; i++){
      while(!st.isEmpty() && prices[st.peek()] >= prices[i]) {
        prices[st.pop()] -= prices[i];
      }
      st.add(i);
    }
    return prices;
  }
}