import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public String evaluate(String s, List<List<String>> knowledge) {
		Map<String, String> knowledgeMap = new HashMap<>();
		for (List<String> keyAndValue : knowledge) {
			knowledgeMap.put(keyAndValue.getFirst(), keyAndValue.get(1));
		}

		StringBuilder result = new StringBuilder();
		boolean parsingBracketPair = false;
		int substituteStartIndex = -1;
		char[] sChars = s.toCharArray();
		for (int i = 0; i < sChars.length; i++) {
			char c = sChars[i];
			if (parsingBracketPair) {
				if (c == ')') {
					parsingBracketPair = false;
					result.append(knowledgeMap.getOrDefault(s.substring(substituteStartIndex, i), "?"));
				}
			} else {
				if (c == '(') {
					parsingBracketPair = true;
					substituteStartIndex = i + 1;
				} else {
					result.append(c);
				}
			}
		}

		return result.toString();
	}
}