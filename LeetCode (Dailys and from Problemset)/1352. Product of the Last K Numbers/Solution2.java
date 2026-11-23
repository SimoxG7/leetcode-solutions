import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

  private final List<Integer> lst;
  private int currMultiplier;
  private int lastZero;

  public ProductOfNumbers() {
    this.lst = new ArrayList<>();
    currMultiplier = 1;
    lastZero = -1;
  }

  public void add(int num) {
    if (num == 0) {
      lastZero = lst.size();
      currMultiplier = 1;
    } else {
      currMultiplier *= num;
    }
    lst.add(currMultiplier);
  }

  public int getProduct(int k) {
    int n = lst.size();
    if (Math.max(n - k, 0) <= lastZero) return 0;
    else if (n <= k) return lst.get(n - 1);
    else return lst.get(n - 1) / lst.get(Math.max(n - k - 1, 0));
  }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */