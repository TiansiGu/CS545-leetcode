/**
 * LC 538. Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 * Binary Search Tree
 */

public class LC538 {

    private int curVal = 0;  // the current summation of all keys greater than an original root key
    /**
     * Convert BST to Greater Tree
     * recursion solution
     * Traverse in order: right, root, left (inverse of in-order traversal)
     * Do summation as traversing the tree
     * @return the Greater Tree's root node
     * Time: O(n), Space: O(h), in worst case O(n), given the number of nodes is n.
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    /**
     * Help method called by convertBST, inverse of inorder traversal
     * update value at each node, and keep track of the current summation by updating curVal
     * @param root the root of current tree (subtree) that is being traversed
     */
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        curVal += root.val;
        root.val = curVal;
        traverse(root.left);
    }
}
