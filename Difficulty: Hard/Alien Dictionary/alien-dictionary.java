// User function Template for Java
class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    boolean isInvalid = false;  // Flag to detect invalid dictionary
    
    /**
     * Find the order of characters in an alien dictionary
     * 
     * Problem: Given a sorted dictionary of alien language, find the order of characters.
     * 
     * Approach: Topological Sort (Kahn's Algorithm)
     * 1. Compare consecutive words to find character ordering
     * 2. Build a directed graph where edge u->v means 'u' comes before 'v'
     * 3. Detect invalid cases: cycles or prefix violations
     * 4. Use topological sort to find valid character ordering
     * 
     * Time: O(N*M + 26) where N = number of words, M = average word length
     * Space: O(26) for graph and arrays
     */
    public String findOrder(String[] words) {
        // Track which characters exist in the dictionary
        int[] exist = new int[26];
        
        // Track incoming edges for each character (for topological sort)
        int indegree[] = new int[26];
        
        // Mark all characters that appear in any word as existing
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exist[ch - 'a'] = 1;
            }
        }
        
        // Count total unique characters in the dictionary
        int V = 0;
        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1) V++;
        }
        
        // Build the adjacency list by comparing consecutive words
        getAdj(words);
        
        // If invalid dictionary detected (prefix violation), return empty string
        if (isInvalid) return "";
        
        // Calculate indegree for each character based on graph edges
        for (int i = 0; i < 26; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        // Initialize queue with all characters that have indegree 0
        // These are characters with no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1 && indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        // Perform topological sort using Kahn's algorithm
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            
            // Reduce indegree of neighbors
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                
                // If indegree becomes 0, add to queue
                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        
        // If topological sort didn't process all characters, there's a cycle
        // Cycle means invalid/inconsistent dictionary
        if (topo.size() != V) return "";
        
        // Convert character indices back to characters
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            char c = (char) (it + (int) ('a'));
            ans.append(c);
        }
        
        return ans.toString();
    }
    
    /**
     * Build adjacency list by comparing consecutive words
     * Creates directed edges based on first differing character
     * Also detects invalid dictionaries (prefix violations)
     * 
     * @param words - array of words in alien dictionary order
     */
    private void getAdj(String[] words) {
        // Initialize adjacency list for all 26 possible characters
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Compare each pair of consecutive words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            
            boolean foundDifference = false;
            
            // Find the first position where characters differ
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    // c1 comes before c2 in alien alphabet
                    // Add directed edge: c1 -> c2
                    adj.get(c1 - 'a').add(c2 - 'a');
                    foundDifference = true;
                    break;
                }
            }
            
            // Invalid dictionary case: longer word before its prefix
            // Example: "abc" before "ab" violates dictionary ordering
            // In valid dictionaries, prefixes always come first
            if (!foundDifference && word1.length() > word2.length()) {
                isInvalid = true;
                return;
            }
        }
    }
}