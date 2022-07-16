// Write method path that returns a path of zeros and ones to a target node 
// in a tree. A path is a sequence of nodes from the root to the target 
// node, with "0" for left and "1" for right.

// In the tree below, path(tree,7) returns "000" and path(tree,13) returns 
// "10". If there is more than one path, return the shortest path. If 
// there is more than one shortest path, return the alphabetically first 
// of these paths.

// If there is no target node return "nopath".

public class FindPath {
    private String res="";
    public String path(TreeNode root, int target) {
        // write code here
        if (root.info == target) {
            return "";
        }
        helper(root, target, "");

        if (res.length()== 0) {
            return "nopath";
        }
        return res;
    }

    public void helper(TreeNode t, int tar, String result) {
        if (t == null) {
            return;
        }

        if (t.info == tar) {
            if (res.length() == 0) {
                res = result;
            }
            else if (result.length() < res.length()) {
                res = result;
            }
            else if (result.length() == res.length()) {
                if (result.compareTo(res) < 0) {
                    res = result;
                }
            }
        }

        if (t.left != null) {
            helper(t.left, tar, result + "0");
        }

        if (t.right != null) {
            helper(t.right, tar, result + "1");
        }
    }
}