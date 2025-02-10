//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Pair {
    int node;
    int dis;
    
    public Pair(int n, int d) {
        node = n;
        dis = d;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        int V = n + 1;
        
        List<List<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
                adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
                adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int[] dis = new int[V];
        int[] parent = new int[V];
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) parent[i] = i;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.dis - p2.dis);
        pq.add(new Pair(1, 0));
        dis[1] = 0;
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int d = p.dis;
            
            for (Pair adjNode: adj.get(node)) {
                if (d + adjNode.dis < dis[adjNode.node]) {
                    dis[adjNode.node] = d + adjNode.dis;
                    pq.add(new Pair(adjNode.node, dis[adjNode.node]));
                    parent[adjNode.node] = node;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        // System.out.println(Arrays.toString(dis));
        
        if (dis[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }
        
        int node = n;
        int wt = dis[n];
        while(parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        
        ans.add(1);
        ans.add(wt);
        
        
        Collections.reverse(ans);
        // System.out.println(ans);
        return ans;
    }
}
