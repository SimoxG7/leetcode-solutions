class Solution {
  public String answerString(String word, int numFriends) {
    // If there's only one friend, give them the whole candy
    if (numFriends == 1)
      return word;

    // Initially, the biggest piece is empty
    String maxP1 = "";

    // Calculate the maximum length of the piece we can take
    // If we divide everything equally, it's like this
    int maxLength = word.length() - numFriends + 1;

    // Iterate through all possible starting positions for our piece
    for (int i = 0; i < word.length(); i++) {
      String temp;

      // Check if we can take a piece of length maxLength starting at position i
      if (i + maxLength <= word.length()) {
        // If we can, take a piece of length maxLength
        temp = word.substring(i, i + maxLength);
      } else {
        // If we can't, take a piece until the end of the string
        temp = word.substring(i);
      }

      // Compare the current piece with the biggest one we've found so far
      if (temp.compareTo(maxP1) > 0) {
        // If the current piece is bigger, update the biggest piece
        maxP1 = temp;
      }
    }

    // Return the biggest piece we could find
    return maxP1;
  }
}