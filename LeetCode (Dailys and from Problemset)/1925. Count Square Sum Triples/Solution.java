class Solution {
	public int countTriples(int n) {
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int req = (int) Math.sqrt(i * i + j * j);
				if ((req * req) == (i * i + j * j) && req <= n)
					res += 2;
			}
		}
		return res;
	}
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
// public int countTriples(int n) {
// List<int[]> triples = pythagoreanTriplesGenerator(n);
// int cnt = 0;
// for (int[] triple : triples) {
// boolean isSimmetric = triple[0] == triple[1];
// cnt += (isSimmetric ? 1 : 2) * (n / triple[2]);
// }
// return cnt;
// }

// private List<int[]> pythagoreanTriplesGenerator(int upperBound) {
// List<int[]> triples = new ArrayList<>();
// // m must be at least 2 and grows until m^2 + 1 exceeds max
// for (int m = 2; m <= upperBound; m++) {
// for (int k = 1; k < m; k++) {
// // Must be coprime and m-k must be odd
// if (((m - k) % 2 == 1) && gcd(m, k) == 1) {
// int a = m * m - k * k;
// int b = 2 * m * k;
// int c = m * m + k * k;
// if (c > upperBound) {
// continue; // skip values outside bound
// }
// if (a > b) {
// int temp = a;
// a = b;
// b = temp;
// }
// triples.add(new int[] { a, b, c });
// }
// }
// }
// return triples;
// }

// private int gcd(int a, int b) {
// while (b != 0) {
// int t = b;
// b = a % b;
// a = t;
// }
// return a;
// }
// }