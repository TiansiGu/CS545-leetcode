/**
 * Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */

public class LC106 {
    /**
     * Binary Tree, recursion, Pre-order
     * @param inorder inorder traversal results of tree
     * @param postorder postorder traversal results of tree
     * @return the root of the tree we construct
     * Time: O(n^2), search for root based on value in inorder takes linear time
     * Space: O(n)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {
        if (endIn == startIn) return null;
        // tree's root must be the last element of postorder array
        int rootVal = postorder[endPost - 1];
        if (endIn - startIn == 1) return new TreeNode(rootVal);

        // cut inorder arr into root, left, and right
        // According to the val of root (unique makes it possible)，find where the root is in inorder arr
        int i; //i is the index of the root
        for (i = startIn; i < endIn; i++) {
            if (inorder[i] == rootVal) break;
        }
        int leftStartIn = startIn;
        int leftEndIn = i;
        int rightStartIn = i+1;
        int rightEndIn = endIn;

        // cut postorder arr into root, left, and right
        // According to the number of elements the left subtree (come from left range of inorder arr), cut postorder arr
        int leftStartPost = startPost;
        int leftEndPost = startPost + (i - startIn);
        int rightStartPost = leftEndPost;
        int rightEndPost = endPost - 1;

        // recursion, process left/right ranges of inorder, postorder arr
        TreeNode root = new TreeNode(rootVal);
        root.left = traversal(inorder, leftStartIn, leftEndIn, postorder, leftStartPost, leftEndPost);
        root.right = traversal(inorder, rightStartIn, rightEndIn, postorder, rightStartPost, rightEndPost);

        return root;
    }
}
