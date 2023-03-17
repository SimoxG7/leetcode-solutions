import java.util.ArrayList;
import java.util.List;

class Trie {

  class Node {

    public String value;
    public List<Node> lst;
    public boolean isTerminal = false;

    public Node() {
      lst = new ArrayList<>();
      this.value = "";
    }

    public Node(String value) {
      lst = new ArrayList<>();
      this.value = value;
    }

    public Node(String value, boolean isTerminal) {
      lst = new ArrayList<>();
      this.value = value;
      this.isTerminal = isTerminal;
    }
  }

  Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    StringBuilder curr = new StringBuilder();
    Node currNode = root;
    boolean changed = false;

    for (int i = 0; i < word.length(); i++) {
      curr.append(word.charAt(i));
      String temp = curr.toString();
      changed = false;
      for (int j = 0; j < currNode.lst.size(); j++) {
        String s = currNode.lst.get(j).value;
        if (s.equals(temp) && s.length() == word.length() && currNode.lst.get(j).isTerminal == true) {
          return;
        } else if (s.equals(temp)) {
          currNode = currNode.lst.get(j);
          changed = true;
          break;
        }
      }
      if (!changed) {
        currNode.lst.add(new Node(temp));
        currNode = currNode.lst.get(currNode.lst.size() - 1);
      }
    }

    currNode.isTerminal = true;
    // System.out.println("inserted: " + word);
    // print(root);
    // System.out.println("ENDPRINT");

  }

  public boolean search(String word) {
    // System.out.println("searching for: " + word);
    // print(root);
    // System.out.println("ENDPRINT");

    StringBuilder curr = new StringBuilder();
    Node currNode = root;

    for (int i = 0; i < word.length(); i++) {
      curr.append(word.charAt(i));
      String temp = curr.toString();
      boolean found = false;
      for (int j = 0; j < currNode.lst.size(); j++) {
        String s = currNode.lst.get(j).value;
        if (s.equals(temp) && s.length() == word.length() && currNode.lst.get(j).isTerminal == true) {
          // System.out.println("result: " + true);
          return true;
        } else if (s.equals(temp)) {
          currNode = currNode.lst.get(j);
          found = true;
        }
      }
      if (!found) {
        // System.out.println("result: " + false);
        return false;
      }
    }
    // System.out.println("result: " + false);
    return false;
  }

  public boolean startsWith(String prefix) {
    StringBuilder curr = new StringBuilder();
    Node currNode = root;
    // System.out.println("starting with: " + prefix);
    // print(root);
    // System.out.println("ENDPRINT");

    for (int i = 0; i < prefix.length(); i++) {
      curr.append(prefix.charAt(i));
      String temp = curr.toString();
      boolean found = false;
      for (int j = 0; j < currNode.lst.size(); j++) {
        String s = currNode.lst.get(j).value;
        if (s.equals(temp) && s.length() == prefix.length()) {
          // System.out.println("result: " + true);
          return true;
        } else if (s.equals(temp)) {
          currNode = currNode.lst.get(j);
          found = true;
        }
      }
      if (!found) {
        // System.out.println("result: " + false);
        return false;
      }
    }
    // System.out.println("result: " + false);
    return false;
  }

  public void print(Node root) {
    System.out.println("-" + root.value + ":" + root.isTerminal);
    for (Node sub : root.lst) {
      print(sub);
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
  boolean isCompleteWord;
  TrieNode[] children;

  public TrieNode() {
    isCompleteWord = false; // when the word is complete (mark that node as true)
    children = new TrieNode[26]; // for 26 possible Childrens (for next letter)
  }
}

// class Trie {
//   TrieNode root;

//   public Trie() {
//     root = new TrieNode();
//   }

//   public void insert(String word) {
//     TrieNode node = root;
//     for (char c : word.toCharArray()) {
//       int index = c - 'a';
//       if (node.children[index] == null) {
//         node.children[index] = new TrieNode();
//       }
//       node = node.children[index];
//     }
//     node.isCompleteWord = true;
//   }

//   public boolean search(String word) {
//     TrieNode node = root;
//     for (char c : word.toCharArray()) {
//       int index = c - 'a';
//       if (node.children[index] == null) {
//         return false;
//       }
//       node = node.children[index];
//     }
//     return node.isCompleteWord;
//   }

//   public boolean startsWith(String prefix) {
//     TrieNode node = root;
//     for (char c : prefix.toCharArray()) {
//       int index = c - 'a';
//       if (node.children[index] == null) {
//         return false;
//       }
//       node = node.children[index];
//     }
//     return true;
//   }
// }