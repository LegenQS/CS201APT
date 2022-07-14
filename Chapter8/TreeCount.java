// Write a method that returns the number of nodes of a binary tree.

import java.util.ArrayList;
public class TreeCount {
    
    public int count(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        ArrayList<TreeNode> cur = new ArrayList<>();
        ArrayList<TreeNode> next = new ArrayList<>();
        cur.add(tree);

        int number = 1;
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

            number += cur.size();

        }
        return number; 
    }
}