package jamal.dataStuctureDesign;

import java.util.HashMap;
import java.util.Map;
public class MyTrie {
    MyTrieNode root = new MyTrieNode();

    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.addR("jamal");
        myTrie.addR("jamalahmed");
        myTrie.addR("j0ames");
        myTrie.printAllWords();
        myTrie.deleteR("jamal");
        System.out.println();
        myTrie.printAllWords();
        System.out.println(myTrie.match("jama.ahmed"));
    }

    private void add(String word) {
        MyTrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new MyTrieNode());
            }
            current = current.children.get(c);
        }
        current.endWord = true;
    }

    private void addR(String word) {
        addR(root, word, 0);
    }

    private void addR(MyTrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            root.endWord = true;
            return;
        }
        char c = word.charAt(idx);
        MyTrieNode node = root.children.get(c);
        if (node == null) {
            node = new MyTrieNode();
            root.children.put(c, node);
        }
        addR(node, word, idx + 1);
    }

    private boolean deleteR(MyTrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            if (!root.endWord) {
                return false;
            }
            root.endWord = false;
            return root.children.size() == 0;
        }
        char c = word.charAt(idx);
        MyTrieNode node = root.children.get(c);
        if (node == null) {
            return false;
        }
        boolean deleteIt = deleteR(node, word, idx + 1);
        if (deleteIt) {
            root.children.remove(c);
            return root.children.size() == 0;
        }
        return false;
    }

    public boolean match(String expression) {
        return match(root, expression, 0);
    }

    private boolean match(MyTrieNode root, String expression, int idx) {
        if (idx >= expression.length()) {
            return root.endWord;
        }
        char c = expression.charAt(idx);
        if (c != '.') {
            MyTrieNode node = root.children.get(c);
            if (node == null) {
                return false;
            }
            return match(node, expression, idx + 1);
        } else {
            for (Map.Entry<Character, MyTrieNode> entry : root.children.entrySet()) {
                if (match(entry.getValue(), expression, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean deleteR(String word) {
        return deleteR(root, word, 0);
    }

    public void printAllWords() {
        printWord(root, "");
    }

    private void printWord(MyTrieNode root, String word) {
        if (root == null) {
            System.out.println(word);
            return;
        }
        if (root.endWord) {
            System.out.println(word);
        }

        for (Map.Entry<Character, MyTrieNode> entry : root.children.entrySet()) {
            printWord(entry.getValue(), word + entry.getKey());
        }
    }

    class MyTrieNode {
        Map<Character, MyTrieNode> children = new HashMap();
        boolean endWord;
    }
}

