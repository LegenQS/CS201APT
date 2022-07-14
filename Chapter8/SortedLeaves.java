// Challenge

// Write method values that returns the values stored in the leaves 
// of its tree parameter tree. Each value stored in in a leaf is a 
// number between 65 and 90, inclusive, and should be interpreted 
// as a corresponding letter "A" through "Z".

// The values should be returned as a sorted array of strings, each 
// string a single letter "A" through "Z".

// Leaves have no children.

import java.util.*;

public class SortedLeaves {
    public String[] values(TreeNode tree) {
        // replace with working code
        if (tree == null) {
            return new String[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        TreeNode s = null;
        List<String> res = new ArrayList<>();
        
        while (queue.size() != 0) {
            s = queue.remove();
            if (isLeaf(s)) {
                if (s.info >= 65 && s.info <= 90) {
                    res.add(String.valueOf((char) s.info));
                }
            }
            else {
                if (s.left != null) {
                    queue.offer(s.left);
                }
                if (s.right != null) {
                    queue.offer(s.right);
                }
            }
        }

        String[] result = new String[res.size()];
        res.toArray(result);
        Arrays.sort(result);

        return result;
    }

    public boolean isLeaf(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return true;
        }
        return false;
    }
}