/**
 * LC 669. Trim a Binary Search Tree
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
public class LC669 {
    // recursion solution
    // if root is in range, root.left=trim(root.left), root.right=trim(root.right)
    // if root < low,  return trim(root.right)
    // if root > high, return trim(root.left)
    // Time: O(n); Space: O(h), in the worst case O(n)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // base case
        if (root == null) {
            return null;
        }
        // recursive cases
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
        else if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        else { //root.val > high
            return trimBST(root.left, low, high);
        }
    }
}
