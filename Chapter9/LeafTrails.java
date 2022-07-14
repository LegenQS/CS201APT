// Write method trails that returns an array of the 
// binary encoded root-to-leaf paths for each leaf 
// node of its tree parameter tree.
// Values stored in leaf nodes will be unique, that
// is the same value will not appear in more than 
// one leaf.

// In traversing from the root to a leaf a path is 
// represented by going left or right. Going left 
// is encoding by a zero and going right is encoded 
// by a one. The path left,left,right would thus be
//  encoded as "001" in the binary encoding of the 
//  root-to-leaf path.

// The strings stored in the array should be sorted 
// by the value stored in the leaf node represented
// by the path. See the examples for details.

import java.util.Map;
import java.util.TreeMap;
public class LeafTrails {
    private Map<Integer, String> result = new TreeMap<>();

    public String[] trails(TreeNode tree) {
        // replace with working code
        String tag = new String();
        leafcount(tree, tag);

        return result.values().toArray(new String[0]);
        
    }

    public void leafcount(TreeNode node, String tag){
        if (node.left != null) {
            leafcount(node.left, tag+"0");
        }
        if (node.right != null) {
            leafcount(node.right, tag+"1");
        }
        if (node.left == null && node.right == null) {
            result.put(node.info, tag);
        }
    }
}