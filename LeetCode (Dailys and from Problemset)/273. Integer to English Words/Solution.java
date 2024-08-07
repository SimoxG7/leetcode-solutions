class Solution {

  private final String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
  private final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] doubleDigits = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String hundred = "Hundred ";
  private final String thousand = "Thousand ";
  private final String million = "Million ";
  private final String billion = "Billion ";
  private final int hundredNum = 100;
  private final int thousandNum = 1_000;
  private final int millionNum = 1_000_000;
  private final int billionNum = 1_000_000_000;

  public String numberToWords(int num) {
    if (num == 0) return "Zero";
    StringBuilder res = new StringBuilder();
    if (num >= billionNum) {
      int innerNum = num / billionNum;
      res.append(handleHundreds(Integer.toString(innerNum)) + billion);
    }
    num %= billionNum;
   
    if (num >= millionNum) {
      int innerNum = num / millionNum;
      res.append(handleHundreds(Integer.toString(innerNum)) + million);
    }
    num %= millionNum;
   
    if (num >= thousandNum) {
      int innerNum = num / thousandNum;
      res.append(handleHundreds(Integer.toString(innerNum)) + thousand);
    }
    num %= thousandNum;

    res.append(handleHundreds(Integer.toString(num)));

    return res.toString().strip();
  }

  private String handleHundreds(String numString) {
    int num = Integer.parseInt(numString);
    StringBuilder res = new StringBuilder();
    if (num >= hundredNum) {
      res.append(digits[num / 100] + " " + hundred);
    } 
    num = num % hundredNum;
    if (num == 0) {
      return res.toString();
    } else if (num < 10) {
      res.append(digits[num] + " ");
    } else if (num < 20) {
      res.append(teens[num - 10] + " ");
    } else {
      res.append(doubleDigits[num / 10 - 2] + " ");
      if (num % 10 != 0) {
        res.append(digits[num % 10] + " ");
      }
    }
    return res.toString();
  }
}