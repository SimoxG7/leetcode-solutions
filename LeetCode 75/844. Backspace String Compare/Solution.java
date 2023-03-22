import java.util.ArrayList;
import java.util.List;

class Solution {
  public boolean backspaceCompare(String s, String t) {
    List<Character> slist = new ArrayList<>();
    List<Character> tlist = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '#') {
        if (!slist.isEmpty()) slist.remove(slist.size()-1);
      } else slist.add(s.charAt(i));
    }

    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == '#') {
        if (!tlist.isEmpty()) tlist.remove(tlist.size()-1);
      } else tlist.add(t.charAt(i));
    }

    if (slist.size() != tlist.size()) return false;

    for (int i = 0; i < slist.size(); i++) {
      if (slist.get(i) != tlist.get(i)) return false;
    }
    return true;
  }
}