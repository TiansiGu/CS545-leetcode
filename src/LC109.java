/**
 * Leetcode 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Recursion
 * Time: O(n), n is the node number of input
 * Space: O(n), list takes O(n), recursion stack expense is O(lgn) -> In total is O(n)
 */
public class LC109 {
    // Solution func
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // convert linked list to array list, get O(1) retrieve time
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode result = traversal(list, 0, list.size()-1);
        return result;
    }

    // Helper func
    private TreeNode traversal(List<Integer> list, int left, int right) {
        // base case
        if (left > right) return null;
        if (left == right) return new TreeNode(list.get(left));
        // recursive class
        int mid = left + (right - left) / 2;
        // list is sorted, so elements to the left of mid is smaller than mid,
        // elements to the right of mid is larger than mid
        // so recursively construct the tree fulfills the condition of BST
        TreeNode node = new TreeNode(list.get(mid));
        node.left = traversal(list, left, mid-1);
        node.right = traversal(list, mid+1, right);
        return node;
    }
}
