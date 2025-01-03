//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int sum = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        pq.add(new Vertex(0, 0));
        boolean[] vis = new boolean[adj.size()];

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();

            if (vis[v.label]) continue;

            vis[v.label] = true;
            sum += v.distance;

            for (int i = 0; i < adj.get(v.label).size(); i++) {
                int label = adj.get(v.label).get(i)[0];
                int wt = adj.get(v.label).get(i)[1];

                if (!vis[label]) {
                    pq.add(new Vertex(label, wt));
                }
            }
        }

        return sum;
    }
}

class Vertex {
        int label;
        int distance;

        public Vertex(int label, int distance) {
            this.label = label;
            this.distance = distance;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }