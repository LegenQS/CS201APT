// Challenge

// An essential part of circuit design and general system optimization is 
// critical path analysis. On a chip, the critical path represents the 
// longest path any signal would have to travel during execution. In this 
// problem we will be analyzing chip designs to determine their critical 
// path length. The chips in this problem will not contain any cycles, 
// i.e. there exists no path from one component of a chip back to itself.

// Given a String[] connects representing the wiring scheme, and a String[] 
// costs representing the cost of each connection, your method will return 
// the size of the most costly path between any 2 components on the chip. 
// In other words, you are to find the longest path in a directed, acyclic 
// graph. Element j of connects will list the components of the chip that 
// can be reached directly from the jth component (0-based). Element j of 
// costs will list the costs of each connection mentioned in the jth 
// element of connects. As mentioned above, the chip will not contain any 
// cyclic paths.

// For example:

// connects = {"1 2", "2", ""}
// costs    = {"5 3", "7", ""}

// In this example, component 0 connects to components 1 and 2 with costs 5 
// and 3 respectively. Component 1 connects to component 2 with a cost of 7. 
// All connections mentioned are directed. This means a connection from 
// component i to component j does not imply a connection from component j 
// to component i. Since we are looking for the longest path between any 2 
// components, your method would return 12.

import java.util.*;

public class Circuits {
    private int res = 0;
    private HashSet<Integer> undefined = new HashSet<>();
    private Integer[][] cost;

    public int howLong(String[] connects, String[] costs) {
        // fill in code here
        cost = new Integer[connects.length][connects.length];

        for (int i = 0; i < connects.length; i++) {
            if (connects[i].equals("")) {
                undefined.add(i);
                continue;
            }
            String[] node = connects[i].split(" ");
            String[] val = costs[i].split(" ");

            for (int j=0;j<node.length;j++) {
                cost[i][Integer.parseInt(node[j])] = Integer.parseInt(val[j]);
            }
        }

        for (int i=0;i<connects.length;i++) {
            if (!undefined.contains(i)) {
                helper(i, 0);
            }
        }
        
        return res;
    }

    public void helper(int idx, int val) {
        if (undefined.contains(idx)) {
            return ;
        }

        for (int i=0;i<cost[idx].length;i++) {
        
            if (cost[idx][i] != null) {
                res = Math.max(res, val + cost[idx][i]);
                helper(i, val + cost[idx][i]);
            }
        }


    }
}