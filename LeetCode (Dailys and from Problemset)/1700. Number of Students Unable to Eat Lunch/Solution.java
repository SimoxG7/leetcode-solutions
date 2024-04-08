class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    int cont[] = new int[2];
    int n = students.length;
    for (int i = 0; i < n; i++) {
      cont[students[i]]++;
    }
    for (int i = 0; i < n; i++) {
      if (cont[sandwiches[i]] == 0) {
        break;
      }
      cont[sandwiches[i]]--;
    }
    return cont[0] + cont[1];
  }
}