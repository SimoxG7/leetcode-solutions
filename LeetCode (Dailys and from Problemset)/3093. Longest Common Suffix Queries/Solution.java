class Solution {

  class Trie {
    Trie child[];
    int val;

    Trie() {
      val = -1;
      child = new Trie[26];
    }
  }

  public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

    Trie root = new Trie();
    root.val = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < wordsContainer.length; i++) {
      insert(root, wordsContainer[i], i, wordsContainer);
      min = Math.min(min, wordsContainer[i].length());
    }

    // root.val = min;

    int res[] = new int[wordsQuery.length];

    for (int i = 0; i < wordsQuery.length; i++) {
      res[i] = search(root, wordsQuery[i]);
    }

    return res;

  }

  public void insert(Trie root, String word, int idx, String[] wordsContainer) {
    Trie node = root;

    for (int i = word.length() - 1; i >= 0; i--) {
      char ch = word.charAt(i);
      if (node.child[ch - 'a'] == null) {
        Trie newNode = new Trie();
        node.child[ch - 'a'] = newNode;

        node.child[ch - 'a'].val = idx;
      }
      if (wordsContainer[node.val].length() > word.length())
        node.val = idx;

      node = node.child[ch - 'a'];
    }
    if (wordsContainer[node.val].length() > word.length())
      node.val = idx;

  }

  public int search(Trie root, String word) {
    Trie node = root;

    for (int i = word.length() - 1; i >= 0; i--) {
      char ch = word.charAt(i);
      if (node.child[ch - 'a'] == null)
        break;
      node = node.child[ch - 'a'];
    }

    return node.val;
  }
}