/*You are required to complete this method */
class GfG {
    public static int countDistinctSubstring(String st) {
        Trie trie = new Trie();
        for (int i = 0; i < st.length(); i++)
            trie.insert(st.substring(i));
        
        return countNodes(trie.getRoot());
    }
    
    // once the trie is built with all the suffixes
    // we can just count the number of nodes.
    // because it represents the distinct substrings
    private static int countNodes(Node root) {
        if (root == null) return 0;
        
        int count = 1;
        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) 
                count += countNodes(root.links[i]);
        }
        
        return count;
    }
    
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public Node getRoot() {
        return this.root;
    }
    
    public void insert(String word) {
        Node node = root;

        for (char c: word.toCharArray()) {
            if (!node.containsKey(c)) node.put(c, new Node());

            node = node.get(c);
        }

        node.setEndOfWord();
    }
    
    public boolean search(String word) {
        Node node = root;

        for (char c: word.toCharArray()) {
            if (!node.containsKey(c)) return false;

            node = node.get(c);
        }

        return node.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for (char c: prefix.toCharArray()) {
            if (!node.containsKey(c)) return false;

            node = node.get(c);
        }

        return true;
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