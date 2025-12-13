import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

	class Pair<T1, T2> {
		public T1 first;
		public T2 second;

		public Pair(T1 first, T2 second) {
			this.first = first;
			this.second = second;
		}
	}

	public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
		List<Pair<String, Short>> collector = new ArrayList<>();
		String[] businessPriority = new String[] { "electronics", "grocery", "pharmacy", "restaurant" };
		for (int i = 0; i < code.length; i++) {
			if (!isActive[i])
				continue;
			String business = businessLine[i];
			short businessPriorityValue = -1;
			for (short businessIndex = 0; businessIndex < 4; businessIndex++) {
				if (business.equals(businessPriority[businessIndex])) {
					businessPriorityValue = businessIndex;
					break;
				}
			}
			if (businessPriorityValue == -1) continue;
			if (!code[i].matches("[A-Za-z0-9_]+")) continue;
			collector.add(new Pair<>(code[i], businessPriorityValue));
		}
		Collections.sort(collector, (o1, o2) -> {
			int diff = Short.compare(o1.second, o2.second);
			if (diff == 0) return o1.first.compareTo(o2.first);
			return diff;
		});
		return collector.stream().map(pair -> pair.first).toList();
	}
}