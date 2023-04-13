class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int pushindex = 0;
    int popindex = 0; 
    for (int val : pushed) {
      pushed[pushindex++] = val; 
      while (pushindex > 0 && pushed[pushindex - 1] == popped[popindex]) { 
        pushindex--; 
        popindex++;
      }
    }
    return pushindex == 0;
  }
}