// This is how the UTF-8 encoding would work:

//      Number of Bytes   |        UTF-8 Octet Sequence             |               Decimal Ranges
//                        |              (binary)                   |
//    --------------------+-----------------------------------------+-------------------------------------------------
//             1          |   0xxxxxxx                              | [0 - 127]
//             2          |   110xxxxx 10xxxxxx                     | [192 - 223] [128 - 191]
//             3          |   1110xxxx 10xxxxxx 10xxxxxx            | [224 - 239] [128 - 191] [128 - 191]
//             4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx   | [240 - 247] [128 - 191] [128 - 191] [128 - 191]

class Solution {
  public boolean validUtf8(int[] data) {
    int remainingBytes = 0;
    for (int i = 0; i < data.length; i++) {
      int octet = data[i];
      if (remainingBytes == 0) {
        if ((octet >> 7) == 0b0) continue;
        else if ((octet >> 5) == 0b110) remainingBytes = 1;
        else if ((octet >> 4) == 0b1110) remainingBytes = 2;
        else if ((octet >> 3) == 0b11110) remainingBytes = 3;
        else return false;
      } else {
        if ((octet >> 6) != 0b10 || remainingBytes-- <= 0) return false;
        // if ((octet >> 6) == 0b10 && remainingBytes-- > 0) continue;
        // return false;
      }
    }
    return remainingBytes == 0;
  }
}

// class Solution {
// public boolean validUtf8(int[] data) {
// int currentSequenceLength = 0, currentSequenceSize = 0;
// boolean newSegment = true;
// for (int i = 0; i < data.length; i++) {
// int octet = data[i];
// if (newSegment) {
// if (octet <= 127) continue;
// else if (octet >= 192 && octet <= 223) {
// newSegment = false;
// currentSequenceLength = 2;
// currentSequenceSize = 1;
// } else if (octet >= 224 && octet <= 239) {
// newSegment = false;
// currentSequenceLength = 3;
// currentSequenceSize = 1;
// } else if (octet >= 240 && octet <= 247) {
// newSegment = false;
// currentSequenceLength = 4;
// currentSequenceSize = 1;
// } else return false;
// } else {
// if (octet >= 128 && octet <= 191 && currentSequenceSize++ <
// currentSequenceLength) {
// if (currentSequenceSize == currentSequenceLength) newSegment = true;
// }
// else return false;
// }
// }
// return currentSequenceLength == currentSequenceSize;
// }
// }