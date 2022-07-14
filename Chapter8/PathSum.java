// Write a method that returns 1 if there is a root-to-leaf path 
// whose node values sum to target and returns 0 if there is no 
// such root-to-leaf path.

public class PathSum {
    private int result=0;
    public int hasPath(int target, TreeNode tree){
        // replace with working code
        if (tree == null) {
            return 0;
        }
        else if (tree.left == null && tree.right == null) {
            if (tree.info == target) {
                return 1;
            }
            else {
                return 0;
            }
        }

        Myloop(target, tree);

        return this.result;
    }

    public void Myloop(int target, TreeNode tree) {
        if (target == tree.info) {
            this.result = 1;
        }
        else {
            if (tree.left != null) {
                Myloop(target - tree.info, tree.left);
            }
            if (tree.right != null) {
                Myloop(target - tree.info, tree.right);
            }
        }
    }
}