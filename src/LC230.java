/**
 * Leetcode 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * Binary Search Tree
 */

import java.util.*;

public class LC230 {
    /** Solution1: iterative approach
     * T: O(h + k), in the worst case O(n)
     * S: O(h), in the worst case O(n)
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> sdk = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !sdk.isEmpty()) {
            if (curr != null) {
                sdk.push(curr);
                curr = curr.left;
            }
            else {
                curr = sdk.pop();
                k--;
                if (k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return -1;
    }


    /** Solution2: recursion in-order traversal
     stop when there is k elements in the list
     * T: O(h + k), in the worst case O(n)
     * S: O(h), in the worst case O(n)
     */
    public int kthSmallestRecursion(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list, k);
        return list.get(k - 1);
    }

    private List<Integer> traversal(TreeNode root, List<Integer> list, int k) {
        if (root == null) return list;
        if (list.size() == k) return list;
        traversal(root.left, list, k);
        list.add(root.val);
        traversal(root.right, list, k);
        return list; //return to the previous level of recursion
    }
}
