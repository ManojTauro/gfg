class Solution {
    public static int countSubs(String s) {
        int len = s.length();
        
        Node root = new Node();
        int count = 0;
        
        for (int i = 0; i < len; i++) {
            Node node = root;
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);

                if (!node.contains(c)) {
                    node.put(c, new Node());
                    count++;
                }
                
                node = node.next(c);
            }
        }
        
        return count;
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