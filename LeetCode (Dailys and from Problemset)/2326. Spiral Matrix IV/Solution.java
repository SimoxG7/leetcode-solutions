import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    int[][] spiral = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.fill(spiral[i], -1);
    ListNode curr = head;
    if (curr == null)
      return spiral;
    for (int i = 0; i < m; i++) {
      int j = 0;
      for (j = i; j < n; j++) {
        if (spiral[i][j] == -1) {
          spiral[i][j] = curr.val;
          curr = curr.next;
          if (curr == null)
            return spiral;
        } else {
          j = j - 1;
          break;
        }
        if (j == n - 1)
          break;
      }
      int k = 0;
      for (k = i + 1; k < m; k++) {
        if (spiral[k][j] == -1) {
          spiral[k][j] = curr.val;
          curr = curr.next;
          if (curr == null)
            return spiral;
        } else {
          k = k - 1;
          break;
        }
        if (k == m - 1)
          break;
      }
      int l = 0;
      for (l = j - 1; l >= 0; l--) {
        if (spiral[k][l] == -1) {
          spiral[k][l] = curr.val;
          curr = curr.next;
          if (curr == null)
            return spiral;
        } else {
          l = l + 1;
          break;
        }
        if (l == 0)
          break;
      }
      int o = 0;
      for (o = k - 1; o >= 0; o--) {
        if (spiral[o][l] == -1) {
          spiral[o][l] = curr.val;
          curr = curr.next;
          if (curr == null)
            return spiral;
        } else {
          o = o + 1;
          break;
        }
        if (o == 0)
          break;
      }
    }
    return spiral;

  }
}