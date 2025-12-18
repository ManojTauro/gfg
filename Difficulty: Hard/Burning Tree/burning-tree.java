/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();

        Node targetNode = updateParents(root, parentMap, target);

        Set<Integer> vis = new HashSet<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(targetNode);
        vis.add(targetNode.data);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i ++) {
                Node node = q.poll();

                if (node.left != null && !vis.contains(node.left.data)) {
                    q.add(node.left);
                    vis.add(node.left.data);
                }

                if (node.right != null && !vis.contains(node.right.data)) {
                    q.add(node.right);
                    vis.add(node.right.data);
                }

                if (parentMap.get(node) != null && !vis.contains(parentMap.get(node).data)) {
                    q.add(parentMap.get(node));
                    vis.add(parentMap.get(node).data);
                }
            }

            level++;
        }

        return level - 1;
    }
    
    private Node updateParents(Node root, Map<Node, Node> map, int target) {
        Node targetNode = new Node(-1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.data == target) {
                targetNode = cur;
            }

            if (cur.left != null) {
                map.put(cur.left, cur);
                q.add(cur.left);
            }

            if (cur.right != null) {
                map.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        
        return targetNode;
    }
}