import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  public int largestPathValue(String colors, int[][] edges) {

    List<List<Integer>> adjList = new ArrayList<>();
    int length = colors.length();
    int inDegree[] = new int[length];
    int colorsDP[][] = new int[length][26];
    int visited = 0;

    for (int i = 0; i < length; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int start = edges[i][0];
      int end = edges[i][1];
      adjList.get(start).add(end);
      inDegree[end]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int parent = queue.poll();
      int parentColor = colors.charAt(parent) - 'a';
      colorsDP[parent][parentColor] = colorsDP[parent][parentColor] + 1;
      for (Integer child : adjList.get(parent)) {
        inDegree[child]--;
        if (inDegree[child] == 0) {
          queue.add(child);
        }
        for (int i = 0; i < 26; i++) {
          colorsDP[child][i] = Math.max(colorsDP[child][i], colorsDP[parent][i]);
        }
      }
      visited++;
    }

    if (visited != length)
      return -1;

    int maxColor = 0;

    for (int i = 0; i < colorsDP.length; i++) {
      for (int j = 0; j < 26; j++) {
        maxColor = Math.max(maxColor, colorsDP[i][j]);
      }
    }
    return maxColor;
  }
}