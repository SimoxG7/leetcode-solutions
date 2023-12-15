import java.util.List;

class Solution {
  public String destCity(List<List<String>> paths) {
    for (List<String> path : paths) {
      String candidate = path.get(1);
      boolean good = true;
      for (List<String> otherPath : paths) {
        if (otherPath.get(0).equals(candidate)) {
          good = false;
          break;
        }
      }
      if (good) {
        return candidate;
      }
    }
    return "";
  }
}
