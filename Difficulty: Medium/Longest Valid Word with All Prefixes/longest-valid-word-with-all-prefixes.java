class Solution {
    public String longestValidWord(String[] words) {
        Trie trie = new Trie();
        
        for (String word: words) trie.insert(word);
        
        String longest = "";
        
        for (String word: words) {
            if (trie.checkIfAllPrefixExists(word)) {
                if (word.length() > longest.length()) longest = word;
                else if (word.length() == longest.length() && word.compareTo(longest) < 0) longest = word;
            }
        }
        
        return longest;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        
        for (char c: word.toCharArray()) {
            if (!node.containsKey(c)) return false;
            
            node = node.get(c);
            if (node.isEndOfWord() == false) return false;
        }
        
        return true;
    }
    
    public void insert(String word) {
        Node node = root;

        for (char c: word.toCharArray()) {
            if (!node.containsKey(c)) node.put(c, new Node());

            node = node.get(c);
        }

        node.setEndOfWord();
    }
}

class Node {
    Node links[] = new Node[26];
    boolean endOfWord;

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    public Node get(char c) {
        return links[c - 'a'];
    }

    public void setEndOfWord() {
        this.endOfWord = true;
    }

    public boolean isEndOfWord() {
        return this.endOfWord;
    }
}