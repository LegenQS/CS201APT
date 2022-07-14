// Write method tighten that removes every node with 
// a single child (either left or right), replacing 
// such nodes with their single child. This tightening 
// process is repeatedly applied so that when completed 
// all nodes have either zero or two children.

import java.util.*;

public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
        // replace with working code
        if (t == null) {
            return t;
        }
        TreeNode node, node1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t);

        while (queue.size() != 0) {
            node = queue.remove();
            if (isLeaf(node)) {
                continue;
            }
            if (isSingle(node)) {
                if (node.left != null) {
                    node1 = node.left;
                } else {
                    node1 = node.right;
                }
                node.info = node1.info;
                node.left = node1.left;
                node.right = node1.right;
                node1 = null;
                queue.offer(node);
            } 
            else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return t;
    }

    public boolean isSingle(TreeNode t) {
        if (t.left == null && t.right == null) {
            return false;
        } else if (t.left != null && t.right != null) {
            return false;
        }
        return true;
    }

    public boolean isLeaf(TreeNode t) {
        if (t.left == null && t.right == null) return true;
        return false;
    }
}