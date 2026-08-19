
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Set<Integer>> reservedRowToReservedSeatSet = new HashMap<>();

    for (int[] reservedSeat : reservedSeats) {
      int reservationRow = reservedSeat[0];
      int reservationCol = reservedSeat[1];
      reservedRowToReservedSeatSet.computeIfAbsent(reservationRow, key -> new HashSet<>()).add(reservationCol);
    }

    int totalFourGroups = Math.max((n - reservedRowToReservedSeatSet.size()), 0) * 2;
    
    for (Set<Integer> reservedRowSeats : reservedRowToReservedSeatSet.values()) {
      boolean isLeftGroupPossible = true, isMiddleGroupPossible = true, isRightGroupPossible = true;

      for (Integer reservedSeat : reservedRowSeats) {
        if (reservedSeat == 1 || reservedSeat == 10) continue;

        if (reservedSeat <= 3) isLeftGroupPossible = false;
        else if (reservedSeat <= 5) {
          isLeftGroupPossible = false;
          isMiddleGroupPossible = false;
        } else if (reservedSeat <= 7) {
          isMiddleGroupPossible = false;
          isRightGroupPossible = false;
        } else isRightGroupPossible = false;
      }

      if (isLeftGroupPossible && isRightGroupPossible) totalFourGroups += 2;
      else if (isLeftGroupPossible || isMiddleGroupPossible || isRightGroupPossible) totalFourGroups++;
    }

    return totalFourGroups;
  }
}