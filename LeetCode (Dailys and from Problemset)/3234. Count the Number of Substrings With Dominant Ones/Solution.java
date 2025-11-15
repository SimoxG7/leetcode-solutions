class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length();
    int[] prev_zero = new int[n + 1];
    prev_zero[0] = -1;
    int res = 0;

    for (int i = 0; i < n; i++) {
      if (i == 0 || s.charAt(i - 1) == '0') {
        prev_zero[i + 1] = i;
      } else {
        prev_zero[i + 1] = prev_zero[i];
      }
    }

    for (int end = 1; end <= n; end++) {
      int zero_count = s.charAt(end - 1) == '0' ? 1 : 0;
      int current_pos = end;

      while (current_pos > 0 && zero_count * zero_count <= n) {
        int segment_length = end - prev_zero[current_pos];
        int one_count = segment_length - zero_count;

        if (zero_count * zero_count <= one_count) {
          int max_valid_length = one_count - zero_count * zero_count + 1;
          int available_length = current_pos - prev_zero[current_pos];
          res += Math.min(available_length, max_valid_length);
        }

        current_pos = prev_zero[current_pos];
        zero_count++;
      }
    }

    return res;
  }
}