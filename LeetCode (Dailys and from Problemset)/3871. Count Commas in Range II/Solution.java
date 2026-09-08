class Solution {
  public long countCommas(long n) {
    long nextCommaLocation = 1000;
    long commas = 0;
    while (n >= nextCommaLocation) {
      commas += n - nextCommaLocation + 1;
      nextCommaLocation *= 1000;
    }
    return commas;
  }
}
