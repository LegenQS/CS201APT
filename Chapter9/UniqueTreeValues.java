// Write method unique that returns a sorted list of 
// the unique values stored in the tree referenced 
// by root.

import java.util.*;

public class UniqueTreeValues {
    public int[] unique(TreeNode root) {
        // write code here
        if (root == null) {
            return new int[0];
        }
        TreeSet<Integer> res = new TreeSet<>();
        Queue<TreeNode> node = new LinkedList<>();
        TreeNode mid;

        node.offer(root);

        while (node.size() != 0) {
            mid = node.remove();
            res.add(mid.info);
            if (mid.left != null) {
                node.offer(mid.left);
            }
            if (mid.right != null) {
                node.offer(mid.right);
            }
        }

        int[] val = new int[res.size()];
        int pos = 0;
        Iterator<Integer> iter = res.iterator();
        while (iter.hasNext()) {
            val[pos++] = (int) iter.next();
        }

        return val;
    }
}