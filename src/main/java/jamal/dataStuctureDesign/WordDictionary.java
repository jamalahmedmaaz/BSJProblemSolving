package jamal.dataStuctureDesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
class WordDictionary {

    MyTrie trie = new MyTrie();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("jamal");
        wordDictionary.addWord("");
        System.out.println(wordDictionary.search("jam.."));
        System.out.println(wordDictionary.search("j.."));
        System.out.println(wordDictionary.search("....."));
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, trie.root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isEndOfWord();
        }
        if (chs[k] != '.') {
            return node.children.get(chs[k]) != null && match(chs, k + 1, node.children.getOrDefault(chs[k], null));
        } else {
            for (Map.Entry<Character, TrieNode> i : node.children.entrySet()) {
                if (match(chs, k + 1, i.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean atSameLevel(int i, List<int[]> ints, int size) {
        for (int[] ele : ints) {
            if (i == ele[0] && ele[1] == size) {
                return true;
            }
        }
        return false;
    }

    class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;

        Map<Character, TrieNode> getChildren() {
            return children;
        }

        boolean isEndOfWord() {
            return endOfWord;
        }

        void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }

    class MyTrie {
        TrieNode root;

        MyTrie() {
            root = new TrieNode();
        }

        void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            current.setEndOfWord(true);
        }

        boolean containsNode(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord();
        }

        boolean startsWith(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return true;
        }

        boolean isEmpty() {
            return root == null;
        }

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */