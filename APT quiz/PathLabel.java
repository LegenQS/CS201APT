public class PathLabel {

    public TreeNode label(TreeNode t) {
        if (t == null) {
            return t;
        }

        return helper(t);
    }

    private TreeNode helper(TreeNode t){ 
        TreeNode left_ = null;
        TreeNode right_ = null;
        if (t.left != null) {
            left_ = helper(t.left);
        }
        if (t.right != null) {
            right_ = helper(t.right);
        }


        if (t.left == null && t.right == null) {
            return new TreeNode(1);
        }
        else if (t.left != null && t.right != null) {
            return new TreeNode(left_.info + right_.info, left_, right_);
        }
        else if (t.left != null) {
            return new TreeNode(left_.info, left_, right_);
        }
        return new TreeNode(right_.info, left_, right_);
    }
}