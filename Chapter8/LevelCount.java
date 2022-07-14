// Write method count that returns the number of nodes 
// in a tree at the level specified by parameter level. 
// The root is at level 0, and the root's children are 
// at level 1. In general, for any node, it's level is 
// one more than its parent's level.


import java.util.ArrayList;

public class LevelCount { 
    public int count(TreeNode t, int level) 
    { 
        // if (t  null) {
        //     return 0;
        // }
        if (t == null) {
            return 0;
        }

        if (level == 0) {
            return 1;
        }
        ArrayList<TreeNode> cur = new ArrayList<>();
        ArrayList<TreeNode> next = new ArrayList<>();
        cur.add(t);

        int status = 0;
        while (cur.size() != 0) {
            for (TreeNode k: cur) {
                if (k.left != null) {
                    next.add(k.left);
                }
                if (k.right != null) {
                    next.add(k.right);
                }
            }
            cur = next;
            next = new ArrayList<>();
            
            status += 1;
            if (status == level) {
                return cur.size();
            }
            if (cur.size() == 0) {
                return 0;
            }
        }

        return 0; 
    } 
}