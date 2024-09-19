class Solution {
	public List<Integer> recUtil(String expression) {
	  List<Integer> ans = new ArrayList<>();
	  int n = expression.length();
	  if (n == 0)
		return ans;
	  if (n == 1) {
		ans.add(Integer.parseInt(expression));
		return ans;
	  }
	  if (n == 2 && Character.isDigit(expression.charAt(0))) {
		ans.add(Integer.parseInt(expression));
		return ans;
	  }
	  for (int i = 0; i < n; i++) {
		char ch = expression.charAt(i);
		if (Character.isDigit(ch))
		  continue;
		List<Integer> left = recUtil(expression.substring(0, i));
		List<Integer> right = recUtil(expression.substring(i + 1));
  
		for (int l : left) {
  
		  for (int r : right) {
			if (ch == '+')
			  ans.add(l + r);
			else if (ch == '-')
			  ans.add(l - r);
			else
			  ans.add(l * r);
  
		  }
		}
	  }
	  return ans;
	}
  
	public List<Integer> diffWaysToCompute(String expression) {
	  return recUtil(expression);
	}
  }