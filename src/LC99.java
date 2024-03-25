/**
 * Leetcode 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 * Binary Search Tree
 */

import java.util.Stack;

public class LC99 {
    /**
     * Inorder traversal, iterative approach
     * T: O(n) in worst case
     * S: O(h), h is the tree's height; in worst case O(n)
     * @param root
     */
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, pre = null; //used for traversal
        TreeNode p1 = null, p2 = null; //used to mark nodes to be swapped
        TreeNode tmp = null; //used to mark the node 1 place behind p1 in inorder traversal
        Stack<TreeNode> sdk = new Stack<>();
        while (!sdk.isEmpty() || cur != null) {
            if (cur != null) {
                sdk.push(cur);
                cur = cur.left;
            }
            else {
                cur = sdk.pop();
                if (pre != null && p1 == null && pre.val > cur.val) {
                    p1 = pre;
                    tmp = cur;
                }
                if (p1 != null && cur.val < tmp.val) {
                    p2 = cur;
                    break;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        // If p2 is not found elsewhere, it must be at the tmp place
        // (one node after p1 in inorder traversal order)
        if (p2 == null) {
            p2 = tmp;
        }
        // swap by exchanging values of p1 and p2
        int tmp_val = p1.val;
        p1.val = p2.val;
        p2.val = tmp_val;
    }
}
