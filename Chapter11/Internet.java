// One of the many nice things about the Internet is that it doesn't have 
// a central server anywhere in the world. That is, the Internet is 
// decentralized. In theory, this means that if a router (a device that 
// makes sure messages reach the proper destination) connected to the 
// Internet crashes, it's still possible to create a connection between 
// any two remaining routers. In this problem you are to examine how true 
// this is, given a configuration of how the routers are connected to each 
// other. Two routers can be connected either directly or indirectly (i.e. 
// by passing through one or more directly connected routers). Initially, 
// all routers are connected to each other.

// A router is an articulation point if the removal of that router will 
// split the remaining routers into (at least) two parts. That is, if 
// there exist two routers, neither of which is the removed router, which 
// after the removal can't connect which each other.

// The configuration will be given as a String[], where each element 
// describes one router (the first element being router 0, etc). Each 
// element will contain a space separated sequence of non-negative 
// integers. If the integer j appears in element i then router i is 
// directly connected with router j. There will be exactly one space 
// between the integers, and there will be no leading or trailing 
// spaces. No integer will contain any unnecessary leading zeros. 
// All direct connections are bi-directional, so if the integer i is 
// in element j, then the integer j will be in element i. All integers 
// will be valid routers.

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