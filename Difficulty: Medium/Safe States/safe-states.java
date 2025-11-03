import java.util.*;

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Reverse graph construction
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revGraph.add(new ArrayList<>());
        }

        int[] outDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                revGraph.get(v).add(u); // reverse edge
                outDegree[u]++;         // track original outdegree
            }
        }

        // Queue for terminal nodes
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (outDegree[i] == 0) q.add(i);
        }

        boolean[] safe = new boolean[V];

        // Kahn’s Algorithm (BFS)
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : revGraph.get(node)) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Collect and sort safe nodes
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) result.add(i);
        }

        Collections.sort(result);
        return result;
    }
}