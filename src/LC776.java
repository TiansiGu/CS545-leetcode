/**
 * Leetcode 776. Split BST
 * https://leetcode.com/problems/split-bst/description/
 */

public class LC776 {
    /**
     * Recursion
     * Time: O(h), in the worst case O(n)
     * Space: O(h), in the worst case O(n)
     */
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) return new TreeNode[] {null, null};
        //target at right subtree -> res[0] start from root
        if (root.val <= target) {
            //splitRight[0] nodes all <= target, splitRight[1] nodes all > target
            TreeNode[] splitRight = splitBST(root.right, target);
            //make root res[0]
            //let all nodes in root <= target
            root.right = splitRight[0];
            splitRight[0] = root;
            return splitRight;
        }
        //target at left subtree -> res[1] start from root
        else {
            //splitLeft[0] nodes all < target, splitLeft[1] nodes all > target
            TreeNode[] splitLeft = splitBST(root.left, target);
            //make root res[1]
            //left all nodes on root > target
            root.left = splitLeft[1];
            splitLeft[1] = root;
            return splitLeft;
        }
    }

}
