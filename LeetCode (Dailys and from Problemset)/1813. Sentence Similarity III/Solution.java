class Solution {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    String[] split1 = sentence1.split(" ");
    String[] split2 = sentence2.split(" ");

    if (split1.length > split2.length) {
      return areSentencesSimilar(sentence2, sentence1);
    }

    int i = 0;
    while (i < split1.length && split1[i].equals(split2[i])) {
      i++;
    }

    while (i < split1.length && split1[i].equals(split2[i + split2.length - split1.length])) {
      i++;
    }

    return i == split1.length;
  }
}