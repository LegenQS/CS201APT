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