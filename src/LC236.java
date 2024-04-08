/**
 * Leetcode 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */

public class LC236 {
    /**
     * Binary Tree, Recursion, Depth First Search
     * Post-order traversal, return to the previous call stack
     * @param root tree root
     * @param p tree node
     * @param q tree node
     * @return the lowest common ancestor of "root"
     * Time: O(n); Space: O(h), worst case O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        else if (left == null && right != null) {
            return right;
        }
        else if (left != null && right == null) {
            return left;
        }
        else return root;
    }
}
