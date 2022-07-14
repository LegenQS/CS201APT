import java.util.ArrayList;

public class TreeImbalance {

    public int imbalance(TreeNode t) {
        int max_val = 0;
        if (t == null){
            return max_val;
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        result.add(t);
        while (result.size()>0){
            TreeNode s = result.remove(0);
            max_val = Math.max(max_val, helper(s));

            if (s.left != null) {
                result.add(s.left);
            }
            if (s.right != null){
                result.add(s.right);
            }
        }
        return max_val;
    }

    private int helper(TreeNode t){
        int a = 0;
        int b = 0;
        if (t != null) {
            int result_l = count(t.left);
            int result_r = count(t.right);
            return Math.abs(result_l-result_r);
        }
        return 0;
    }

    private int count(TreeNode t){
        int count_ = 0;
        if (t == null) {
            return 0;
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        result.add(t);
        
        while (result.size() > 0) {
            TreeNode rem = result.remove(0);
            if (rem.left != null) {
                result.add(rem.left);
            }
            if (rem.right != null){
                result.add(rem.right);
            }
            count_ += 1;
        }
        return count_;
    }
}