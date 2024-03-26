import java.util.ArrayList;
import java.util.List;

class Solution {
  List<String> ans;

  public List<String> findWords(char[][] board, String[] words) {
    Trie t = new Trie();
    for (String s : words)
      t.insert(s);
    ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sol(board, i, j, t.root, new StringBuilder());
      }
    }
    return ans;
  }

  public void sol(char[][] mat, int i, int j, TrieNode root, StringBuilder sb) {
    char ch = mat[i][j];
    if (ch == '1' || root.children[ch - 'a'] == null)
      return;
    root = root.children[ch - 'a'];
    sb.append(ch);
    if (root.isWord) {
      ans.add(sb.toString());
      root.isWord = false;
    }
    mat[i][j] = '1';
    if (i > 0)
      sol(mat, i - 1, j, root, sb);
    if (j > 0)
      sol(mat, i, j - 1, root, sb);
    if (i < mat.length - 1)
      sol(mat, i + 1, j, root, sb);
    if (j < mat[0].length - 1)
      sol(mat, i, j + 1, root, sb);
    sb.deleteCharAt(sb.length() - 1);
    mat[i][j] = ch;
  }
}

class TrieNode {
  char data;
  boolean isWord;
  TrieNode[] children;

  public TrieNode(char data) {
    this.data = data;
    isWord = false;
    children = new TrieNode[26];
  }
}

class Trie {
  public TrieNode root;

  public Trie() {
    root = new TrieNode('0');
  }

  public void insert(String word) {
    insert(root, word);
  }

  public void insert(TrieNode root, String s) {
    if (s.length() == 0) {
      root.isWord = true;
      return;
    }
    int idx = s.charAt(0) - 'a';
    TrieNode child = root.children[idx];
    if (child == null) {
      child = new TrieNode(s.charAt(0));
      root.children[idx] = child;
    }
    insert(child, s.substring(1));
  }

  public boolean search(String word) {
    return search(root, word);
  }

  public boolean search(TrieNode root, String s) {
    if (s.length() == 0)
      return root.isWord;
    int idx = s.charAt(0) - 'a';
    TrieNode child = root.children[idx];
    if (child == null)
      return false;
    return search(child, s.substring(1));
  }
}

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Objects;
// import java.util.Set;

// class Solution {

// public class TrieNode {

// private Map<Character, TrieNode> children;
// private String content;
// private boolean isWord;

// public TrieNode(String content, boolean isWord) {
// this.children = new HashMap<>();
// this.content = content;
// this.isWord = isWord;
// }

// public Map<Character, TrieNode> getChildren() {
// return this.children;
// }

// public String getContent() {
// return this.content;
// }

// public boolean getIsWord() {
// return this.isWord;
// }

// public void setIsWord(boolean isWord) {
// this.isWord = isWord;
// }

// }

// public class Trie {
// private TrieNode root;

// public Trie() {
// root = new TrieNode("", false);
// }

// public void insert(String word) {
// TrieNode current = root;
// for (char c : word.toCharArray()) {
// current = current.getChildren().computeIfAbsent(c, d -> new TrieNode(c + "",
// false));
// }
// current.setIsWord(true);
// }

// public boolean find(String word) {
// TrieNode current = root;
// for (int i = 0; i < word.length(); i++) {
// char ch = word.charAt(i);
// TrieNode node = current.getChildren().get(ch);
// if (Objects.isNull(node))
// return false;
// current = node;
// }
// return current.getIsWord();
// }

// public void delete(String word) {
// delete(root, word, 0);
// }

// private boolean delete(TrieNode current, String word, int index) {
// if (index == word.length()) {
// if (!current.getIsWord())
// return false;
// current.setIsWord(false);
// return current.getChildren().isEmpty();
// }
// char ch = word.charAt(index);
// TrieNode node = current.getChildren().get(ch);
// if (Objects.isNull(node))
// return false;
// boolean shouldDeleteCurrentNode = delete(node, word, index + 1) &&
// !node.getIsWord();
// if (shouldDeleteCurrentNode) {
// current.getChildren().remove(ch);
// return current.getChildren().isEmpty();
// }
// return false;
// }
// }

// private List<String> lst;

// public List<String> findWords(char[][] board, String[] words) {
// Trie trie = new Trie();
// for (String s : words) trie.insert(s);
// lst = new ArrayList<>();
// for (int i = 0; i < board.length; i++) {
// for (int j = 0; j < board[0].length; j++) {
// sol(board, i, j, trie.root, new StringBuilder());
// }
// }
// return lst;
// }

// public void sol(char[][] mat, int i, int j, TrieNode root, StringBuilder sb)
// {
// char ch = mat[i][j];
// if (ch == '1' || root.getChildren().get(ch) == null)
// return;
// root = root.children[ch - 'a'];
// sb.append(ch);
// if (root.isWord) {
// ans.add(sb.toString());
// root.isWord = false;
// }
// mat[i][j] = '1';
// if (i > 0)
// sol(mat, i - 1, j, root, sb);
// if (j > 0)
// sol(mat, i, j - 1, root, sb);
// if (i < mat.length - 1)
// sol(mat, i + 1, j, root, sb);
// if (j < mat[0].length - 1)
// sol(mat, i, j + 1, root, sb);
// sb.deleteCharAt(sb.length() - 1);
// mat[i][j] = ch;
// }
// }