import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

    Set<String> set = new HashSet<>();
    List<String> res = new ArrayList<>();
    for (String s : supplies) {
      set.add(s);
    }
    boolean flag = true;
    while (flag) {
      flag = false;
      for (int i = 0; i < recipes.length; i++) {
        if (!set.contains(recipes[i])) {
          int x = 0;
          for (int j = 0; j < ingredients.get(i).size(); j++) {
            if (!set.contains(ingredients.get(i).get(j))) {
              x = 1;
              break;
            }
          }
          if (x == 0) {
            flag = true;
            set.add(recipes[i]);
            res.add(recipes[i]);
          }

        }
      }

    }
    return res;
  }
}