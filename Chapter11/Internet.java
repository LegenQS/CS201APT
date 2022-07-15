import java.util.*;

public class Internet {
    private int time = 0;

    public int articulationPoints(String[] routers) {
        // fill in code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int idx = 0;
        for (String s : routers) {
            if (s.equals("")) {
                continue;
            }
            adj.add(new ArrayList<>());
            for (String ss : s.split(" ")) {
                adj.get(idx).add(Integer.parseInt(ss));
            }
            idx++;
        }
        return AP(adj, routers.length);
    }

    public void APUtil(ArrayList<ArrayList<Integer>> adj, int u,
            boolean visited[], int disc[], int low[],
            int parent, boolean isAP[]) {
        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        for (Integer v : adj.get(u)) {
            // If v is not visited yet, DFS recur
            if (!visited[v]) {
                children++;
                APUtil(adj, v, visited, disc, low, u, isAP);

                // Check if the subtree rooted with v has
                // a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If u is not root and low value of one of
                // its child is more than discovery value of u.
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent)
                low[u] = Math.min(low[u], disc[v]);
        }

        // If u is root of DFS tree and has more than two children.
        if (parent == -1 && children > 1)
            isAP[u] = true;
    }

    public int AP(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        int num = 0, par = -1;

        for (int u = 0; u < V; u++)
            if (visited[u] == false)
                APUtil(adj, u, visited, disc, low, par, isAP);

        for (int u = 0; u < V; u++)
            if (isAP[u] == true)
                num += 1;

        return num;
    }
}