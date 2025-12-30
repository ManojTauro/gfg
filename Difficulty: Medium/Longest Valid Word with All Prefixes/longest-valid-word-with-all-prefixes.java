class Solution {
    public String longestValidWord(String[] words) {
        Trie t = new Trie();
        
        for (String word: words) {
            t.insert(word);
        }
        
        int maxLen = 0;
        String ans = "";
        
        for (String word: words) {
            if (t.checkIfAllPrefixExists(word)) {
                if (word.length() > maxLen) {
                    maxLen = word.length();
                    ans = word;
                } else if (word.length() == maxLen) {
                    if (ans.compareTo(word) > 0) ans = word; 
                }
            }
        }
        
        return ans;
        
    }
}

class Node {
    List<Node> links = new ArrayList<>();
    boolean isEnd;

    public Node() {
        for (int i = 0; i < 26; i++) 
            links.add(null);
    }

    boolean contains(char c) {
        int index = c - 'a';
        return links.get(index) != null;
    }

    void put(char c, Node ref) {
        int index = c - 'a';
        links.set(index, ref);
    }

    Node next(char c) {
        int index = c - 'a';
        return links.get(index);
    }

    void updateEnd() {
        this.isEnd = true;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public boolean checkIfAllPrefixExists(String word) {
        Node cur = root;
        
        for (char c: word.toCharArray()) {
            if (!cur.contains(c)) return false;
            
            cur = cur.next(c);
            
            if (!cur.isEnd) return false;
        }
        
        return true;
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.contains(c)) {
                cur.put(c, new Node());
            }
            cur = cur.next(c);
        }

        cur.updateEnd();
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.contains(c)) return false;

            cur = cur.next(c);
        }

        if (cur.isEnd) return true;

        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()) {
            if (!cur.contains(c)) return false;

            cur = cur.next(c);
        }

        return true;
    }
}