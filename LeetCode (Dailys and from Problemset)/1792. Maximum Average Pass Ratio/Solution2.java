import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    Queue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) -> {
      return Double.compare(b.increase, a.increase);
    });

    for (int[] classInfo : classes) {
      int passi = classInfo[0];
      int totali = classInfo[1];
      double currentRatio = (double) passi / totali;
      double newRatio = (double) (passi + 1) / (totali + 1);
      double increase = newRatio - currentRatio;
      maxHeap.offer(new ClassInfo(passi, totali, increase));
    }

    for (int i = 0; i < extraStudents; i++) {
      ClassInfo classInfo = maxHeap.poll();
      classInfo.passi += 1;
      classInfo.totali += 1;
      double currentRatio = (double) classInfo.passi / classInfo.totali;
      double newRatio = (double) (classInfo.passi + 1) / (classInfo.totali + 1);
      classInfo.increase = newRatio - currentRatio;
      maxHeap.offer(classInfo);
    }

    double totalPassRatio = 0;
    for (ClassInfo classInfo : maxHeap) {
      totalPassRatio += (double) classInfo.passi / classInfo.totali;
    }

    return totalPassRatio / classes.length;
  }

  private static class ClassInfo {
    int passi;
    int totali;
    double increase;

    ClassInfo(int passi, int totali, double increase) {
      this.passi = passi;
      this.totali = totali;
      this.increase = increase;
    }
  }

}