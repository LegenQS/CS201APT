// Challenge

// Write method paths that returns an array of all the 
// root-to-leaf paths in its tree parameter. Paths are 
// represented as a string of parent-child node values 
// with the string "->" between each. See the examples 
// for details. The returned array should be sorted.
// Leaves have no children.

import java.util.*;

public class AllPaths {
    private String[] result;
    private ArrayList<String> res = new ArrayList<>();

    public String[] paths(TreeNode t) {
        // replace with working code
        ArrayList<String> val = new ArrayList<>();
        if (t == null) {
            return new String[0];
        }

        DFS(t, val);

        result = new String[res.size()];
        res.toArray(result);
        Arrays.sort(result);

        return result;
    }

    public void DFS(TreeNode t, ArrayList<String> lst) {
        if (isLeaf(t)) {
            lst.add(String.valueOf(t.info));
            res.add(String.join("->", lst));

            return;
        }

        lst.add(String.valueOf(t.info));
        if (t.left != null) {
            DFS(t.left, lst);
            lst.remove(lst.size() - 1);
        }

        if (t.right != null) {
            DFS(t.right, lst);
            lst.remove(lst.size() - 1);
        }
    }

    public boolean isLeaf(TreeNode t) {
        if (t.left == null && t.right == null)
            return true;
        return false;
    }
}