// Write method getLeaves that finds and removes the leaves 
// in a binary tree, repeating this process in a sequence of 
// rounds until the tree is empty. The method returns an 
// array representing each round of leaf removal until the 
// tree is empty.
// Leaves should be visited using an in-order traversal 
// (first left, then right). Each round of leaf-removal is 
// represented by a string with each leaf value removed 
// separated by a space. See the examples for details.

// The returned array contains as many strings are there 
// are rounds of leaf-removal before the tree is empty.

import java.util.*;

public class LeafCollector {
    public String[] getLeaves(TreeNode tree) {
        // replace with working code
        if (tree == null) {
            return new String[0];
        }
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> res1 = new ArrayList<>();

        while (tree != null) {
            if (isLeaf(tree)) {
                res1.add(String.valueOf(tree.info));
                break;
            }
            DFS(tree, res);
            res1.add(String.join(" ", res));
            res = new ArrayList<>();
        }
        String[] result = new String[res1.size()];
        res1.toArray(result);

        return result;
    }

    public void DFS(TreeNode t, ArrayList<String> lst) {
        if (t.left != null) {
            if (isLeaf(t.left)) {
                lst.add(String.valueOf(t.left.info));
                t.left = null;
            }
            else {
                DFS(t.left, lst);
            }
        }

        if (t.right != null) {
            if (isLeaf(t.right)) {
                lst.add(String.valueOf(t.right.info));
                t.right = null;
            }
            else {
                DFS(t.right, lst);
            }
        }
    }

    public boolean isLeaf(TreeNode t) {
        if (t.left == null && t.right == null)
            return true;
        return false;
    }
}