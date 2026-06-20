import java.util.*;

import static java.util.Objects.isNull;

class TimeMap {

  private static class TimeStampAndValue {
    int timeStamp;
    String value;

    TimeStampAndValue(int timeStamp, String value) {
      this.timeStamp = timeStamp;
      this.value = value;
    }
  }

  private final Map<String, List<TimeStampAndValue>> keyToTimeStampAndValue;

  public TimeMap() {
    keyToTimeStampAndValue = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    TimeStampAndValue timeStampAndValue = new TimeStampAndValue(timestamp, value);
    keyToTimeStampAndValue.computeIfAbsent(key, k -> new ArrayList<>()).add(timeStampAndValue);
  }

  public String get(String key, int timestamp) {
    return binarySearch(keyToTimeStampAndValue.get(key), timestamp);
  }

  private String binarySearch(List<TimeStampAndValue> values, int maxTimestamp) {
    if (isNull(values) || values.isEmpty()) return "";

    int left = 0, right = values.size() - 1;
    if (maxTimestamp < values.get(left).timeStamp) return "";

    while (left < right) {
      int mid = left + (right - left) / 2;
      TimeStampAndValue midValue = values.get(mid);
      if (midValue.timeStamp == maxTimestamp) return midValue.value;
      else if (midValue.timeStamp < maxTimestamp) left = mid + 1;
      else right = mid - 1;
    }
    TimeStampAndValue leftValue = values.get(left);
    return leftValue.timeStamp > maxTimestamp ? values.get(left - 1).value : leftValue.value;
  }
}
/*
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
