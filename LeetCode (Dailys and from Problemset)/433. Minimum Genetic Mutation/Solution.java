import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int minMutation(String startGene, String endGene, String[] bank) {
    int totalGenes = bank.length;

    int endGeneBankIndex = -1;
    for (int i = 0; i < totalGenes; i++) {
      if (endGene.equals(bank[i])) {
        endGeneBankIndex = i;
        break;
      }
    }
    if (endGeneBankIndex == -1) return -1;

    List<Integer> oneStepFromStartMutations = new ArrayList<>();
    for (int i = 0; i < totalGenes; i++) {
      if (geneDistance(startGene, bank[i]) == 1) oneStepFromStartMutations.add(i);
    }
    if (oneStepFromStartMutations.isEmpty()) return -1;

    int[][] mutations = new int[totalGenes][totalGenes];
    for (int i = 0; i < totalGenes; i++) {
      for (int j = 0; j < totalGenes; j++) {
        if (i == j) continue;
        int distance = geneDistance(bank[i], bank[j]);
        mutations[i][j] = distance;
        mutations[j][i] = distance;
      }
    }

    int mutationsCount = Integer.MAX_VALUE;
    for (int oneStepMutationIndex : oneStepFromStartMutations) {
      mutationsCount = Math.min(mutationsCount, findTargetMutation(oneStepMutationIndex, endGeneBankIndex, new HashSet<>(), mutations));
    }

    if (mutationsCount == Integer.MAX_VALUE) return -1;
    return 1 + mutationsCount;
  }

  private int findTargetMutation(int startIndex, int endIndex, Set<Integer> excludedIndexes, int[][] mutations) {
    if (startIndex == endIndex) return 0;

    List<Integer> possibleMutations = new ArrayList<>();
    for (int i = 0; i < mutations.length; i++) {
      if (!excludedIndexes.contains(i) && mutations[startIndex][i] == 1) possibleMutations.add(i);
    }

    int minMutations = Integer.MAX_VALUE;
    for (int possibleMutationIndex : possibleMutations) {
      Set<Integer> excludedIndexesUpdated = new HashSet<>(excludedIndexes);
      excludedIndexesUpdated.add(startIndex);
      int foundMutations = findTargetMutation(possibleMutationIndex, endIndex, excludedIndexesUpdated, mutations);
      if (foundMutations == Integer.MAX_VALUE) continue;
      minMutations = Math.min(minMutations, 1 + foundMutations);
    }

    return minMutations;
  }

  private int geneDistance(String gene1, String gene2) {
    int distance = 0;
    for (int i = 0; i < gene1.length(); i++) {
      if (gene1.charAt(i) != gene2.charAt(i))
        distance++;
    }
    return distance;
  }
}