import java.util.LinkedList;
import java.util.Queue;

class Solution {

  private boolean isBinaryTreeValid(int root, int[] leftChild, int[] rightChild) {
    boolean[] visited = new boolean[leftChild.length];
    Queue<Integer> nodeQueue = new LinkedList<>();
    nodeQueue.offer(root);
    visited[root] = true;

    while (!nodeQueue.isEmpty()) {
      int current = nodeQueue.poll();

      if (leftChild[current] != -1) {
        if (visited[leftChild[current]])
          return false;

        nodeQueue.offer(leftChild[current]);
        visited[leftChild[current]] = true;
      }

      if (rightChild[current] != -1) {
        if (visited[rightChild[current]])
          return false;

        nodeQueue.offer(rightChild[current]);
        visited[rightChild[current]] = true;
      }
    }

    for (boolean visit : visited) {
      if (!visit)
        return false;
    }

    return true;
  }

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    boolean[] childCount = new boolean[n];

    for (int child : leftChild) {
      if (child != -1)
        childCount[child] = true;
    }

    for (int child : rightChild) {
      if (child != -1) {
        if (childCount[child])
          return false;

        childCount[child] = true;
      }
    }

    int root = -1;
    for (int i = 0; i < n; ++i) {
      if (!childCount[i]) {
        if (root == -1)
          root = i;
        else
          return false;
      }
    }

    if (root == -1)
      return false;

    return isBinaryTreeValid(root, leftChild, rightChild);
  }

}