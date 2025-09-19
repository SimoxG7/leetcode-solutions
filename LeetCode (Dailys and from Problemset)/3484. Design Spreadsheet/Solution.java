class Spreadsheet {

  private final int[][] spreadsheet;

  public Spreadsheet(int rows) {
    spreadsheet = new int[rows][26];
  }

  public void setCell(String cell, int value) {
    int col = getColFromCell(cell), row = getRowFromCell(cell);
    spreadsheet[row][col] = value;
  }

  public void resetCell(String cell) {
    setCell(cell, 0);
  }

  public int getValue(String formula) {
    String[] splits = formula.split("[=+]", -1);
    String cell1 = splits[1], cell2 = splits[2];
    int value1 = 0, value2 = 0;

    if (Character.isAlphabetic(cell1.charAt(0))) value1 = spreadsheet[getRowFromCell(cell1)][getColFromCell(cell1)];
    else value1 = Integer.parseInt(cell1);

    if (Character.isAlphabetic(cell2.charAt(0))) value2 = spreadsheet[getRowFromCell(cell2)][getColFromCell(cell2)];
    else value2 = Integer.parseInt(cell2);

    return value1 + value2;
  }

  private int getRowFromCell(String cell) {
    return Integer.parseInt(cell.substring(1)) - 1;
  }
  
  private int getColFromCell(String cell) {
    return cell.charAt(0) - 'A';
  }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */