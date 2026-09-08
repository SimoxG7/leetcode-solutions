class Solution {
  public int distinctSubseqII(String s) {
    int MOD = 1_000_000_007;
    int[] oldSubsequenceCount = new int[s.length()];
    int[] lastCharacterCount = new int[26];
    oldSubsequenceCount[0] = 2;
    lastCharacterCount[s.charAt(0) - 'a'] = 1;

    for (int i = 1; i < s.length(); i++) {
      int ch = s.charAt(i) - 'a';
      oldSubsequenceCount[i] = ((2 * oldSubsequenceCount[i - 1]) % MOD
          - lastCharacterCount[ch]
          + MOD) % MOD;
      lastCharacterCount[ch] = oldSubsequenceCount[i - 1];
    }

    return oldSubsequenceCount[s.length() - 1] - 1 + (oldSubsequenceCount[s.length() - 1] > 0 ? 0 : MOD);
  }
}