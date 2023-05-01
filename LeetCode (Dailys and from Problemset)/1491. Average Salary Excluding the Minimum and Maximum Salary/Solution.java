class Solution {
  public double average(int[] salary) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < salary.length; i++) {
      min = Math.min(salary[i], min);
      max = Math.max(salary[i], max);
      sum += salary[i];
    }
    return (double) (sum - min - max) / (double) (salary.length - 2);
  }
}

// class Solution {
// public double average(int[] salary) {
// int tot = 0;
// int min, max;
// if (salary[0] < salary[1]) {
// min = salary[0];
// max = salary[1];
// } else {
// min = salary[1];
// max = salary[0];
// }
// for (int i = 2; i < salary.length; i++) {
// int curr = salary[i];
// if (curr < min) {
// tot += min;
// min = curr;
// } else if (curr > max) {
// tot += max;
// max = curr;
// } else {
// tot += curr;
// }
// }
// return tot / (salary.length - 2);
// }
// }