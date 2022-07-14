// Write method rewire that returns a new tree, isomorphic 
// (same shape) as the tree parameter, but in which each 
// node's info field is equal to that node's height in the 
// tree.


import java.util.ArrayList;

public class HeightLabel {
    public TreeNode rewire(TreeNode tree) {
        // replace with working code
        if (tree == null) {
            return tree;
        }

        Myloop(tree);
        return tree;
    }

    public void Myloop(TreeNode tree) {
        int a = 0, b = 0;
        if (tree.left == null && tree.right == null) {
            tree.info = 1;
            return ;
        }
        else {
            if (tree.left != null) {
                Myloop(tree.left);
                a = tree.left.info;
            }
            if (tree.right != null) {
                Myloop(tree.right);
                b = tree.right.info;
            }
            tree.info = Math.max(a,b) + 1;
        }
    }      
}