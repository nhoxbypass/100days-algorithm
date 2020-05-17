package covid19_1.day14_implement_trie_prefix_tree;

class Solution {
    public static void main(String[] args) {
    }

    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEndOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                } else {
                    node = node.children[c - 'a'];
                }
            }
            return node.isEndOfWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                } else {
                    node = node.children[c - 'a'];
                }
            }
            return true;
        }

        class TrieNode {
            boolean isEndOfWord;
            TrieNode[] children;

            // Initialize your data structure here.
            public TrieNode() {
                this.isEndOfWord = false;
                this.children = new TrieNode[26];
            }
        }
    }

    /*class Trie {
        private Set<String> data;

        *//** Initialize your data structure here. *//*
        public Trie() {
            data = new HashSet<>();
        }

        *//** Inserts a word into the trie. *//*
        public void insert(String word) {
            data.add(word);
        }

        *//** Returns if the word is in the trie. *//*
        public boolean search(String word) {
            for (String item : data) {
                if (item.equals(word))
                    return true;
            }
            return false;
        }

        *//** Returns if there is any word in the trie that starts with the given prefix. *//*
        public boolean startsWith(String prefix) {
            for (String item : data) {
                if (item.startsWith(prefix))
                    return true;
            }
            return false;
        }
    }*/
}