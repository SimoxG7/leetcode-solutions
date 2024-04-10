import java.util.Arrays;

public class Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    int numberOfCards = deck.length;
    int[] result = new int[numberOfCards];

    Arrays.sort(deck);

    return revealCards(deck, result, 0, 0, false);
  }

  private int[] revealCards(int[] deck, int[] result, int deckIndex, int resultIndex, boolean skip) {
    int numberOfCards = deck.length;

    if (deckIndex == numberOfCards) {
      return result;
    }

    while (resultIndex < numberOfCards) {
      if (result[resultIndex] == 0) {
        if (!skip) {
          result[resultIndex] = deck[deckIndex];
          deckIndex++;
        }
        skip = !skip;
      }
      resultIndex++;
    }

    return revealCards(deck, result, deckIndex, 0, skip);
  }
}

// import java.util.Arrays;

// class Solution {
// public int[] deckRevealedIncreasing(int[] deck) {
// int len = deck.length;
// boolean even = len % 2 == 0;
// int[] res = new int[len];
// Arrays.sort(deck);
// int half;
// if (even) half = len/2;
// else half = len/2 + 1;
// for (int i = 0; i < half; i++) {
// res[i*2] = deck[i];
// }
// if (even) {
// int cont = 0;
// for (int i = 0; i < half; i++) {
// if (i % 2 == 0) {
// res[i*2 + 1] = deck[half + cont];
// } else {
// res[i*2 + 1] = deck[len - cont - 1];
// cont++;
// }
// }
// } else {
// int cont = 0;
// for (int i = 0; i < half - 1; i++) {
// if (i % 2 == 0) {
// res[i*2 + 1] = deck[len - cont - 1];
// cont++;
// } else {
// res[i*2 + 1] = deck[half + cont];
// }
// }
// }
// return res;
// }
// }

// //da 1 a n/2 -> 1,x,2,x,...,x,n/2
// //poi se pari: sostituisco in posti dispari
// //n/2 +1, n-1, n/2 + 2, n-2, ...

// //poi se dispari: sostituisco in posti dispari
// //n-1, n/2 + 1, n-2, n/2 + 2, ... n/2