import java.util.Arrays;

class Solution {
  
  class NameWithHeight implements Comparable<NameWithHeight> {

    String name;
    int height;

    NameWithHeight(String name, int height) {
      this.name = name;
      this.height = height;
    }

    @Override
    public int compareTo(NameWithHeight other) {
      return Integer.compare(other.height, this.height); //reverse order
    }
  }

  public String[] sortPeople(String[] names, int[] heights) {
    int n = names.length;
    NameWithHeight[] nameWithHeights = new NameWithHeight[n];
    for (int i = 0; i < n; i++) {
      nameWithHeights[i] = new NameWithHeight(names[i], heights[i]);
    }
    Arrays.sort(nameWithHeights);
    for (int i = 0; i < n; i++) {
      names[i] = nameWithHeights[i].name;
    }
    return names;
  }
}